*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 *
 * @author Sam Kline
 */
public class TestRunner {
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(AllTest.class);
        
        for(Failure failure : result.getFailures()){
            System.out.append(failure.toString());
        }
        
        System.out.println("Tests Successful: " + result.wasSuccessful());
    }
}
