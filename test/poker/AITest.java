/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam
 */
public class AITest {
    
    public AITest() {
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
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Initializer
     */
    @Test
    public void testInitializer() {
        try{
            AI a = new AI(0);
            AI b = new AI(1);
        }catch(Exception e){
            fail();
        }
    }
    
    /**
     * Money handling
     */
    @Test
    public void testMoney(){
        AI ai = new AI(0);
        ai.addMoney(100);
        assertEquals(100, ai.money);
        ai.removeMoney(100);
        assertEquals(0, ai.money);
    }
    
    /**
     * Test of hand tracking
     */
    @Test
    public void testHand(){
        AI ai = new AI(0);

        ai.addCard(new Card(0, 0));
        ai.addCard(new Card(0, 1));
        ai.addCard(new Card(0, 2));
        ai.addCard(new Card(0, 3));
        ai.addCard(new Card(0, 4));
        
        assertEquals(Hands.ROYAL_FLUSH, ai.getHand().determineHand());
    }
    
    /**
     * Test of betting capability
     */
    @Test
    public void testBet(){
        AI ai = new AI(0);
        
        ai.addMoney(100);
        
        ai.addCard(new Card(0, 0));
        ai.addCard(new Card(0, 1));
        ai.addCard(new Card(0, 2));
        ai.addCard(new Card(0, 3));
        ai.addCard(new Card(0, 4));
        
        assertEquals(100, ai.bet(10, 100, 0));
    }
    
    /**
     * Test of card removal
     */
    @Test
    public void testRemoveCards(){
        boolean fail = true;
        for(int i = 0; i < 50000; i++){
            AI ai = new AI(0);
            ai.addCard(new Card(0, 1));
            ai.addCard(new Card(1, 3));
            ai.addCard(new Card(0, 5));
            ai.addCard(new Card(0, 6));
            ai.addCard(new Card(0, 8));
            
            if(ai.removeCards() != 0){
                fail = false;
                break;
            }
            
        }
        if(fail){
            fail();
        }
    }
    
    
    
}
