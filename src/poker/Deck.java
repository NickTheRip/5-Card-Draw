/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author sdk101
 */
public class Deck {
        protected ArrayList<Card> deck = new ArrayList<Card>();
        
        protected void setDeck(ArrayList<Card> d){
            this.deck = d;
        }
        
        public Deck(){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 13; j++){
                    deck.add(new Card(i, j));
                }
            }
        }
        
        public void remove(Card c){
            deck.remove(c);
        }
        
        public boolean hasCard(Card c){
            return deck.contains(c);
        }
        
        public ArrayList<Card> cards(){
            return deck;
        }
        
        public Deck cloneDeck(){
            Deck d = new Deck();
            d.setDeck((ArrayList) deck.clone());
            return d;
        }
        
        public void shuffle(){
            Collections.shuffle(deck);
        }
        
        public int countCards(){
            return deck.size();
        }
        
        public void printAllCard(){
            for(int i = 0; i < deck.size(); i++){
                System.out.println(deck.get(i).toString());
            }
        }
        
        public Card draw(){
            return deck.remove(0);
        }
}
