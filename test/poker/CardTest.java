/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

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
@RunWith(Parameterized.class)
public class CardTest {
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                { 0, 0, "Spades", "Ace" }, { 1, 1, "Diamonds", "King" }, 
                { 2, 2, "Hearts", "Queen" }, { 3, 3, "Clubs", "Jack" },
                { 0, 12, "Spades", "2" }
           });
    }
    
    @Parameter
    public int intSuit;
    
    @Parameter(1)
    public int intValue;
    
    @Parameter(2)
    public String strSuit;
    
    @Parameter(3)
    public String strValue;
    
    public CardTest() {
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
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        Card instance = new Card(intSuit, intValue);
        assertEquals(strSuit, instance.getSuit());
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        Card instance = new Card(intSuit, intValue);
        assertEquals(strValue, instance.getValue());
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        Card instance = new Card(intSuit, intValue);
        assertEquals(strValue + " of " + strSuit, instance.toString());
    }
    
}
