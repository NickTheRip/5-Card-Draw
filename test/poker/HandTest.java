/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;
import poker.Hands;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nsimp
 */
public class HandTest {
       
    private Hand h = new Hand();
    private Deck d;
    private Card c;
    private static HashMap<Hands, Hand> lookup;

    public HandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        lookup = new HashMap();
        
        Hand h = new Hand();
        h.add(new Card(0, 0));
        h.add(new Card(0, 1));
        h.add(new Card(0, 2));
        h.add(new Card(0, 3));
        h.add(new Card(0, 4));
        lookup.put(Hands.ROYAL_FLUSH, h);
        
        h = new Hand();
        h.add(new Card(0, 1));
        h.add(new Card(0, 2));
        h.add(new Card(0, 3));
        h.add(new Card(0, 4));
        h.add(new Card(0, 5));
        lookup.put(Hands.STRAIGHT_FLUSH, h);
        
        h = new Hand();
        h.add(new Card(0, 1));
        h.add(new Card(1, 1));
        h.add(new Card(2, 1));
        h.add(new Card(3, 1));
        h.add(new Card(1, 2));
        lookup.put(Hands.FOUR_OF_A_KIND, h);
        
        h = new Hand();
        h.add(new Card(0, 1));
        h.add(new Card(1, 1));
        h.add(new Card(0, 2));
        h.add(new Card(1, 2));
        h.add(new Card(2, 2));
        lookup.put(Hands.FULL_HOUSE, h);
        
        h = new Hand();
        h.add(new Card(0, 1));
        h.add(new Card(0, 3));
        h.add(new Card(0, 5));
        h.add(new Card(0, 6));
        h.add(new Card(0, 8));
        lookup.put(Hands.FLUSH, h);
        
        h = new Hand();
        h.add(new Card(0, 1));
        h.add(new Card(2, 2));
        h.add(new Card(0, 3));
        h.add(new Card(0, 4));
        h.add(new Card(0, 5));
        lookup.put(Hands.STRAIGHT, h);
        
        h = new Hand();
        h.add(new Card(0, 1));
        h.add(new Card(1, 1));
        h.add(new Card(2, 1));
        h.add(new Card(0, 6));
        h.add(new Card(0, 8));
        lookup.put(Hands.THREE_OF_A_KIND, h);
        
        h = new Hand();
        h.add(new Card(0, 1));
        h.add(new Card(0, 1));
        h.add(new Card(1, 2));
        h.add(new Card(1, 2));
        h.add(new Card(0, 8));
        lookup.put(Hands.TWO_PAIR, h);
        
        h = new Hand();
        h.add(new Card(0, 1));
        h.add(new Card(3, 1));
        h.add(new Card(2, 5));
        h.add(new Card(1, 6));
        h.add(new Card(0, 8));
        lookup.put(Hands.PAIR, h);
        
        h = new Hand();
        h.add(new Card(0, 1));
        h.add(new Card(1, 3));
        h.add(new Card(0, 5));
        h.add(new Card(0, 6));
        h.add(new Card(0, 8));
        lookup.put(Hands.HIGH_CARD, h);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        d = new Deck();
        h = new Hand();
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of size
     */
    @Test
    public void testCardsize() {
        assertEquals(0, h.size());
    }
    /**
     * Test of addition of cards
     */
    @Test
    public void testCardAdd(){
        c = d.draw();
        h.add(c);
        assertEquals(1, h.size());
    }
    /**
     * Test of the Getcards method
     */
    @Test
    public void testGetCards(){
        h = new Hand();
        d = new Deck();
        c = d.draw();
        h.add(c);
        assertEquals(c, h.getCards().get(0));
    }
    
    /**
     * Test of removal of cards
     */
    @Test
    public void testRemoval(){
        Card c = d.draw();
        h.add(c);
        assertEquals(1, h.size());
        h.remove(c);
        assertEquals(0, h.size());
    }
    
    /**
     * Test of hand determination
     */
    @Test
    public void testHandDetermination(){
        Arrays.asList(Hands.values()).forEach(e -> {
            assertEquals(e, lookup.get(e).determineHand());
        });
    }
    
    /**
     * Test of hand comparison
     */
    @Test
    public void testBeats(){
        for(int i = 0; i < 10; i++){
            for(int j = i+1; j< 9; j++){
                assertEquals(true, lookup.get(Hands.values()[i]).beats(lookup.get(Hands.values()[j])));
            }
        }
    }
    
    /**
     * Test of hand cloning
     */
    @Test
    public void testClone(){
        Hand g = lookup.get(Hands.ROYAL_FLUSH).cloneHand();
        assertEquals(false, g.beats(lookup.get(Hands.ROYAL_FLUSH)));
        assertEquals(false, lookup.get(Hands.ROYAL_FLUSH).beats(g));
        assertEquals(false, g == lookup.get(Hands.ROYAL_FLUSH));
    }
}
