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
import java.util.ArrayList;
/**
 *
 * @author Sam
 */
public class EngineTest {
    
    private static Engine e;
    
    public EngineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        e = new Engine(0);
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
     * Test of Gameover
     */
    @Test
    public void testGameOver() {
        e.getPlayer().money = 100;
        assertEquals(true, e.gameInProgress());
        e.getPlayer().money = 0;
        assertEquals(false, e.gameInProgress());
        e.getPlayer().money = 100;
    }
    /**
     * Test Setup
     */
    @Test
    public void testStart(){
        try{
            e.start();
            e.beginRound();
        }catch(Exception e){
            fail();
        }
    }
    /**
     * Test Betting;
     */
    @Test
    public void testBetting(){
        e.getPlayer().money = 20;
        e.roundOneBet(10);
        e.roundTwoBet(10);
        assertEquals(0, e.getPlayer().money);
        assertTrue("Pot has increased, AI Has bet", e.getPot() > 20);
    }
    /**
     * Test Fold mechanics
     */
    @Test
    public void testFolds(){
        e.roundOneBet(10);
        e.getPlayer().money = 0;
        e.aiFold();
        assertTrue("Player money increased", e.getPlayer().money > 10);
    }
    /**
     * Test Card switching
     */
    @Test
    public void testCardSwitch(){
        ArrayList<Card> c = new ArrayList<>();
        e.start();
        e.beginRound();
        try{
            int i = e.changeCards(c);
        }catch(Exception e){
            fail();
        }
    }
    
    
}