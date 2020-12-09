/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.HashMap;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import poker.Hand;
import poker.Card;

/**
 *
 * @author nsimp
 */
public class PlayerTest {
    
    public PlayerTest() {
    
    //private Hand hand = new Hand();
    Player instance = new Player();
    int m = 100;
    instance.hand = new Hand();
      
    }
    
    @BeforeClass
    public static void setUpClass() {
       
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    @Before
    public void setUp() {
    
    }
    /**
     * Test of getHand method, of class Player.
     */
    @Test
    public void testGetHand() {
        
        Deck d = new Deck();
        Card c = d.draw();
        Card c2 = d.draw();
        Player instance = new Player();
        instance.addCard(c);
        Hand expResult = instance.getHand();
        Hand result = instance.getHand();
        assertEquals(expResult, result);
        assertFalse( d.hasCard(c));
        
        
    }

    /**
     * Test of removeCard method, of class Player.
     */
    @Test
    public void testRemoveCard() {
        Deck d = new Deck();
        Card c = d.draw();
        Card c3 = d.draw();
        Player instance = new Player();
        instance.addCard(c);
        instance.getHand();
        instance.addCard(c3);
        instance.removeCard(c);
        instance.getHand();
        assertFalse( d.hasCard(c3));
        assertFalse( d.hasCard(c));
        assertFalse(c != c3);
       
        
    }

    /**
     * Test of addCard method, of class Player.
     */
    @Test
    public void testAddCard() {
        Deck d = new Deck();
        Card c = d.draw();
        Card c2 = c;
        Player instance = new Player();
        instance.addCard(c);
        instance.getHand();
        assertEquals(c2, c);
         assertFalse( d.hasCard(c));
        
       
        
        
    }

    /**
     * Test of addMoney method, of class Player.
     */
    @Test
    public void testAddMoney() {
        Player instance = new Player();
        instance.addMoney(20);
        instance.addMoney(100);
        assertEquals(120,instance.money);
        instance.addMoney(0);
        assertEquals(120,instance.money);
        instance.addMoney(12);
        assertEquals(132, instance.money);
        
        
        
        
    }

    /**
     * Test of removeMoney method, of class Player.
     */
    @Test
    public void testRemoveMoney() {
        Player instance = new Player();
        instance.addMoney(20);
        instance.addMoney(100);
        instance.addMoney(70);
        
        assertEquals(190,instance.money);
        
        instance.removeMoney(50);
        assertEquals(140, instance.money);
        instance.removeMoney(15);
        assertEquals(125, instance.money);
        instance.removeMoney(0);
        assertEquals(125, instance.money);
        
     
        
    }
    
}
