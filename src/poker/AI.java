/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Sam
 */
public class AI extends Player{
    private int difficulty; 
    private final int baseline = 5; //base betting amount
    
    public int bet(int amount, int playerMoney, int round){
        float handStrength = getHand().scoreHand();
        float handScalar = (handStrength - 7)/9; //Strength of hand from 0 to 1
        //Lower difficulty just bets proportionally to hand
        if(difficulty == 0){
            if(amount > this.money){
                return this.money;  //All in mo...
            }
            int scalarbet = (int) Math.min(Math.ceil((handScalar * this.money)), this.money);
            if(scalarbet < amount){
                return amount;
            }
            return scalarbet;
        }
        
        // Higher Difficulty logic:
        // Bluff Chance
        if(difficulty == 1 && Math.random() < .05){
            return this.money;
        }
        
        //Higher difficulty factors in future hands
        Deck d = new Deck();
                for(Card c : hand.getCards()){
                    d.remove(c);
                }
        float futureScore = scorePossiblePermutations(findBestPartialHand(hand), d);
        float futureScalar = (futureScore - 7)/9;
        //Handle large bets first
        if(amount > this.money * .5){
            // Call buff if hand is relatively good
            float scalar = 0;
            if(round == 0){
                scalar = futureScalar;
            }else{
                scalar = (int)(5 * Math.abs((handScalar * this.money)/5));
            }
            if(scalar < .3){
                    //fold
                    return 0;
                }else if(scalar > .7){
                    return amount;
                }else if(Math.random() > .4){
                    return amount;
                }else{
                    return 0;
                }
        }//Otherwise call/bet proportionally
        if(round == 0){
            return Math.max((int)(5 * Math.abs((futureScalar * this.money)/5)), amount);
        }else{
            if(handScalar > .3 || amount < playerMoney * .33){
                //Will finish hand if it has a chance, or thinks the player doesn't
                return amount;// No benefit to raising second round for the AI
            }else{
                return 0;
            }
            
        }
    }
    
    public AI(int aiDifficulty){
        super();
        this.difficulty = aiDifficulty;
    }
    
    public int removeCards(){
        //Removed for optimization
        //this.hand = findBestPartialHand(this.hand);
        if(this.hand.scoreHand() > 9){
            return 0; //Keeps decent hands
        }
        
        Hand h = hand.cloneHand();
        for(Card c: h.getCards()){
            if(Math.random() < .2){
                hand.remove(c);
            }
        }
        return 5-this.hand.size();
    }
    
    private Hand findBestPartialHand(Hand h){
        //Create a deck to draw cards from
        Deck d = new Deck();
        for(Card c : h.getCards()){
            d.remove(c);
        }
        //Now we need all the possible mutations (and their scores)
        HashMap<Hand, Float> Mutations = new HashMap<>();
        for(Hand possibility : removablePermutations(h)){
            Mutations.put(possibility, scorePossiblePermutations(possibility, d));
        }
        //Anything with a score > Current score is likely to be better
        //So find the highest
        float topscore = 0;
        Hand bestHand = new Hand();
        for(Hand possibleBestHand : Mutations.keySet()){
            if(Mutations.get(possibleBestHand) > topscore){
                bestHand = possibleBestHand;
                topscore = Mutations.get(possibleBestHand);
            }
        }
        return bestHand;
    }
    
    private ArrayList<Hand> removablePermutations(Hand h){
        ArrayList<Hand> hands = new ArrayList<>();
        hands.add(h);
        if(h.size() > 1){
            for(Card c : h.getCards()){
                hand = h.cloneHand();
                hand.remove(c);
                hands.addAll(removablePermutations(hand));
            }
        }
        return hands;
                
    }
    
    private float scorePossiblePermutations(Hand h, Deck d){
        if(h.size() == 5){
            return h.scoreHand();
        }
        ArrayList<Hand> PermutationSet = new ArrayList<>();
        PermutationSet.addAll(fractalFill(h, d));
        float total = 0;
        for(Hand potentialHand : PermutationSet){
            total += potentialHand.scoreHand();
        }
        total /= PermutationSet.size();
        return total;
    }

    private ArrayList<Hand> fractalFill(Hand h, Deck d){
        ArrayList<Hand> hands = new ArrayList<>();
        if(h.size() == 5){
            hands.add(h);
            return hands;
        }
        for(Card c : d.cards()){
            Deck newDeck = d.cloneDeck();
            newDeck.remove(c);
            h.add(c);
            hands.addAll(fractalFill(h, newDeck));
        }
        return hands;
    }
}