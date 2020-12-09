/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
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
public class DeckTest {
    
    public DeckTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Deck d = new Deck();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of countCards method, of class Deck.
     */
    @Test
    public void testCountCards() {
        Deck instance = new Deck();
        int expResult = 52;
        int result = instance.countCards();
        assertEquals(expResult, result);
    }

  
    /**
     * Test of remove method, of class Deck.
     */
    @Test
    public void testRemove() {
       Deck instance = new Deck();
        Card c = instance.draw();
        
        instance.remove(c);
        assertFalse( instance.hasCard(c));
        
        
        
       
    }

    /**
     * Test of hasCard method, of class Deck.
     */
    @Test
    public void testHasCard() {
        Deck instance = new Deck();
        Card c = instance.draw();
        int expResult = 51;
        //Card expResult = c;
        int result = instance.countCards();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of cards method, of class Deck.
     */
    @Test
    public void testCards() {
        Deck instance = new Deck();
        Deck instance2 = instance;
        ArrayList<Card> expResult = instance2.cards();
        ArrayList<Card> result = instance.cards();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of cloneDeck method, of class Deck.
     */
    @Test
    public void testCloneDeck() {
        Deck instance = new Deck();
        Card c = instance.draw();
        Deck test = instance;
        boolean expResult = test.hasCard(c);
        boolean result = instance.hasCard(c);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffle() {
        Deck instance = new Deck();
        instance.shuffle();
        System.out.println("shuffle complete");
       
    }

    /**
     * Test of printAllCard method, of class Deck.
     */
    @Test
    public void testPrintAllCard() {
        Deck instance = new Deck();
        instance.printAllCard();
        
        
        
       
    }

    /**
     * Test of draw method, of class Deck.
     */
    @Test
    public void testDraw() {
        Deck instance = new Deck();
        instance.draw();
        int expResult = 51;        
        int result = instance.countCards();

        assertTrue(expResult == result);
        
    }
}
