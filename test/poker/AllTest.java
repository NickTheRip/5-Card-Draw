/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 *
 * @author Sam Kline
 */
@RunWith(Suite.class)
@SuiteClasses({
    CardTest.class,
    DeckTest.class,
    HandTest.class,
    AITest.class,
    EngineTest.class
})
public class AllTest {
    
}
