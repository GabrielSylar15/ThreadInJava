/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThread;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.Thread2;

/**
 *
 * @author hapt61
 */
public class DoSomethingInProcessTime extends Thread {

    int result = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            result += i;
        }
        System.out.println("Result Of DoSomethongInProcessingTime: " + result);
    }

    public void SyncCal() {
        for (int i = 0; i < 10; i++) {
            result += i;
        }
        System.out.println("Result Of DoSomethongInProcessingTime: " + result);
    }

    public String getResult(BigDecimal param) {
        System.out.println("Display: ");
        return result + param.toString();
    }
    
    
}
