/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author Sam
 */
public class Player {
    protected Hand hand;
    protected int money = 0;
    
    public Player(){
        this.hand = new Hand();
    }
    
    public void clearHand(){
        this.hand = new Hand();
    }
    
    public Hand getHand(){
        return hand;
    }
    
    public void removeCard(Card c){
        hand.remove(c);
    }
    
    public void addCard(Card c){
        hand.add(c);
    }
    
    public void addMoney(int m){
        money+= m;
    }
    
    public void removeMoney(int m){
        money-= m;
    }
}
