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
public class Engine {
    private Deck deck;
    
    private Player player;
    private AI ai;
    private int pot;
    private int state;
    HashMap<Integer, String> gameState = new HashMap<>();
    
    private void fillHand(Player p){
        while(p.hand.size() < 5){
            p.addCard(deck.draw());
        }
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public int getAIMoney(){
        return ai.money;
    }
    
    public int getPot(){
        return pot;
    }
    
    public boolean isGameOver(){
        return player.money <= 10 || ai.money <= 10;
    }
    
    public Engine(int aiDifficulty){
        player = new Player();
        pot = 0;
        ai = new AI(aiDifficulty);
        player.addMoney(100);
        ai.addMoney(100);
        deck = new Deck();
        deck.shuffle();
        state = -1;
        gameState.put(-1, "Between Rounds");
        gameState.put(0, "Dealing");
        gameState.put(1, "First Round Betting");
        gameState.put(2, "Card Swapping");
        gameState.put(3, "Second Round Betting");
        gameState.put(4, "Showdown");
    }
    
    public void start(){
        state = 0;
        pot = 10;
        player.removeMoney(5);
        ai.removeMoney(5);        
    }
    
    public Hand getAIHand(){
        return ai.getHand();
    }
    
    public String getPhase(){
        return gameState.get(state);
    }
    
    public int getState(){
        return state;
    }
    
    public void beginRound(){
        deck = new Deck();
        deck.shuffle();
        player.clearHand();
        ai.clearHand();
        fillHand(player);
        fillHand(ai);
        state = 1;
    }
    
    public void roundOneBet(int amount){
        pot += amount;
        player.removeMoney(amount);
        int aiBet = ai.bet(amount, player.money, 0);
        ai.money -= aiBet;
        if(aiBet == 0){
            aiFold();
        }else{
            pot += aiBet;
        }
        state = 2;
    }
        
    public int changeCards(ArrayList<Card> cards){
        for(Card c : cards){
            int i = player.hand.getCards().indexOf(c);
            player.hand.getCards().set(i, deck.draw());
        }
        this.fillHand(player);
        int cardsRemoved = ai.removeCards();
        this.fillHand(ai);
        if(player.money != 0 && ai.money != 0){
            state = 3;
        }else{
            state = 4;
        }
        
        return cardsRemoved;
    }
    
    public void roundTwoBet(int amount){
        player.removeMoney(amount);
        pot += amount;
        int aiBet = ai.bet(amount, player.money, 1);
        if(aiBet == 0){
            aiFold();
        }else{
            pot += aiBet;
        }
        state = 4;
    }
    
    public boolean isPlayerWinner(){
        state = 5;
        if(player.getHand().beats(ai.getHand())){
            player.addMoney(pot);
            return true;
        }else if(ai.getHand().beats(player.getHand())){
            ai.addMoney(pot);
        }else{
            player.addMoney((int) Math.floorDiv(pot, 2));
            ai.addMoney((int) Math.floorDiv(pot, 2));
        }
        return false;        
    }
    
    public void playerFold(){
        ai.addMoney(pot);
        state = 3;
    }
    
    public void aiFold(){
        player.addMoney(pot);
        state = 3;
    }
    
    public boolean gameInProgress(){
        if(player.money >= 10 && ai.money >= 10){
            return true;
        }
        state = 6;
        return false;
    }
    
}
