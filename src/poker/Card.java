/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author sdk101
 */
public class Card {
    
    private int suit, value;
    private String[] cardSuit = {"Spades", "Diamonds", "Hearts", "Clubs"};
    private String[] cardValue = {"Ace", "King", "Queen", "Jack", "10", 
        "9", "8", "7", "6", "5", "4", "3", "2"};
    //TODO: Generalized generation for either suit/value OR reference INTs
    public Card(int cSuit, int cValue){
        suit = cSuit;
        value = cValue;
    }
    
    public String getResourceName(){
        return this.getValue() + this.getSuit();
    }
    
    public String getSuit(){
        String s = cardSuit[suit];
        return s;
    }
    
    public String getValue(){
        String v = cardValue[value];
        return v;
    }
    
    public String toString() {
        String cardInfo = cardValue[value] + " of " + cardSuit[suit];
        return cardInfo;
    }
    
    public boolean equals(Card c){
        return c.getSuit() == this.getSuit() &&
                c.getValue() == this.getValue();
    }
}
