/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hapt61
 */
public class TestThread extends Thread{
    int money = 1000;

    @Override
    public synchronized void run() {
        if(money>0){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            money-=1000;
            System.out.println("Current Money: "+money);
        }else{
            System.out.println("Out of money!");
        }
    }
    
    
}
