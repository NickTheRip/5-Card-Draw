/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
/**
 *
 * @author Sam
 */
public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();
    
    public Hand(){
        this.hand = new ArrayList<Card>();
    }
    
    public void remove(Card card){
        ArrayList<Card> toRemove = new ArrayList<Card>();
        this.hand.forEach((c) -> {
            if(c.equals(card)){
                toRemove.add(c);
            }
        });
        hand.removeAll(toRemove);
    }
    
    public void add(Card card){
        hand.add(card);
    }
    
    public int size(){
        return hand.size();
    }
    
    public ArrayList<Card> getCards(){
        return hand;
    }
    
    public boolean beats(Hand h){
        return this.scoreHand() > h.scoreHand();
    }
    
    public float scoreHand(){ 
        //some initial data organization
        // this seems somewhat inherently messy
        // need to go for some sort of large scale organization
        ArrayList<Card> cards = this.getCards();
        ArrayList<String> suits = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        
        for(Card c: cards){
            if(!suits.contains(c.getSuit())){
                suits.add(c.getSuit());
            }
            if(!values.contains(c.getValue())){
                values.add(c.getValue());
            }
        }
        
        
        boolean flush = false;
        if(suits.size() == 1){
            flush = true;
        }
        
        boolean straight = false;
        boolean royal = false;
        String highcard = "2"; //Will be overwritten, but prevents errors
        
        HashMap<String, Integer> cardValueLookup = new HashMap<>();
        cardValueLookup.put("Ace", 1);
        cardValueLookup.put("2", 2);
        cardValueLookup.put("3", 3);
        cardValueLookup.put("4", 4);
        cardValueLookup.put("5", 5);
        cardValueLookup.put("6", 6);
        cardValueLookup.put("7", 7);
        cardValueLookup.put("8", 8);
        cardValueLookup.put("9", 9);
        cardValueLookup.put("10", 10);
        cardValueLookup.put("Jack", 11);
        cardValueLookup.put("Queen", 12);
        cardValueLookup.put("King", 13);
        
        ArrayList<Integer> cardScores = new ArrayList<>();
        if(values.size() == 5){
            for(String s : values){
                cardScores.add(cardValueLookup.get(s));
                if(cardValueLookup.get(s) > cardValueLookup.get(highcard)){
                    highcard = s;
                }
            }
            // Range checking for straight, with exception for ace
            if(Collections.max(cardScores) - 4 == Collections.min(cardScores)){
                straight = true;
            }
            if(Collections.max(cardScores) == 13 && cardScores.contains(1)
                    && cardScores.contains(12) && cardScores.contains(11) 
                    && cardScores.contains(10)){
                straight = true;
                royal = true;
            }
            
            //If there's an ace, we'll now recast it to 14 for later
            if(cardScores.contains(1)){
                cardScores.remove(cardScores.indexOf(1));
                cardScores.add(14);
            }
            Collections.sort(cardScores, Collections.reverseOrder());
        }
        HashMap<String, Integer> pairs = new HashMap<>();
        ArrayList<String> pureValues = new ArrayList<>();
        for(Card c: cards){
            pureValues.add(c.getValue());
        }
        for(String s : pureValues){
            boolean exists = false;
            for(String t : pairs.keySet()){
                if(t.equals(s)){
                    exists = true;
                }
            }
            if(exists){
                pairs.put(s, pairs.get(s) + 1);
            }else{
                pairs.put(s, 1);
            }
        }
        
        if(royal && straight && flush){
            
            return 16;
        }
        if(straight && flush){
            float score = 15;
            return score + (cardValueLookup.get(highcard)/100);
        }
        if(pairs.containsValue(4)){
            float score = 14;
            for(String k : pairs.keySet()){
                if(pairs.get(k) == 4){
                    score += cardValueLookup.get(k)/100;
                }else{
                    score += cardValueLookup.get(k)/10000;
                }
            }
            return score;
        }
        if(pairs.containsValue(2) && pairs.containsValue(3)){
            float score = 13;
            for(String k : pairs.keySet()){
                if(pairs.get(k) == 3){
                    score += cardValueLookup.get(k)/100;
                }else{
                    score += cardValueLookup.get(k)/10000;
                }
            }
            return score;
        }
        if(flush){
            float score = 12;
            int j = 1;
            for(int i : cardScores){
                score += i/(100^j);
                j++;
            }
            return score;
        }
        if(straight){
            return 11 + cardValueLookup.get(highcard)/100;
        }
        if(pairs.containsValue(3)){
            float score =  10;
            ArrayList<Integer> kickers = new ArrayList<>();
            for(String s : pairs.keySet()){
                if(pairs.get(s) == 1){
                    if(s.equals("Ace")){
                        kickers.add(14);
                    }else{
                        kickers.add(cardValueLookup.get(s));
                    }
                }
            }
            Collections.sort(kickers, Collections.reverseOrder());
            score += kickers.get(0)/100;
            score += kickers.get(1)/10000;
            return score;
        }
        
        // Get Number of pairs
        int pairCount = 0;
        for(String s : pairs.keySet()){
            if(pairs.get(s) == 2){
                pairCount++;
            }
        }
        if(pairCount == 2){
            float score = 9;
            ArrayList<Integer> p = new ArrayList<>();
            int kicker = 0;
            for(String s : pairs.keySet()){
                if(pairs.get(s) == 2){
                    p.add(cardValueLookup.get(s));
                }else{
                    kicker = cardValueLookup.get(s);
                }
            }
            Collections.sort(p, Collections.reverseOrder());
            score += p.get(0)/100;
            score += p.get(1)/10000;
            score += kicker/1000000;
            return score;
        }
        if(pairCount == 1){
            float score =  8;
            ArrayList<Integer> kickers = new ArrayList<>();
            for(String s : pairs.keySet()){
                if(pairs.get(s) == 1){
                    if(s.equals("Ace")){
                        kickers.add(14);
                    }else{
                        kickers.add(cardValueLookup.get(s));
                    }
                }
            }
            Collections.sort(kickers, Collections.reverseOrder());
            score += kickers.get(0)/100;
            score += kickers.get(1)/10000;
            return score;
        }
        //Sort By High Card
        float score = 7;
        int cardsAccountedFor = 0;
        Integer[] kickers = new Integer[pairs.keySet().size()];
        for(String s : pairs.keySet()){
            if(s.equals("Ace")){
                kickers[cardsAccountedFor] = 14;
            }else{
                kickers[cardsAccountedFor] = cardValueLookup.get(s);
            }
            cardsAccountedFor++;
        }
        Arrays.sort(kickers, Collections.reverseOrder());
        for(int i = 1; i < kickers.length; i++){
            score += kickers[(i-1)]/Math.pow(100, i);
        }
        return score;
    }
    
    public Hand cloneHand(){
        Hand h = new Hand();
        for(Card c: hand){
            h.add(c);
        }
        return h;
    }
    
    public Hands determineHand(){
        int score = (int) this.scoreHand();
        switch(score){
            case 16:
                return Hands.ROYAL_FLUSH;
            case 15:
                return Hands.STRAIGHT_FLUSH;
            case 14:
                return Hands.FOUR_OF_A_KIND;
            case 13:
                return Hands.FULL_HOUSE;
            case 12:
                return Hands.FLUSH;
            case 11:
                return Hands.STRAIGHT;
            case 10:
                return Hands.THREE_OF_A_KIND;
            case 9:
                return Hands.TWO_PAIR;
            case 8:
                return Hands.PAIR;
            default:
                return Hands.HIGH_CARD;
        }
    }
}
