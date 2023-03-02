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
public class Banking implements Runnable{

    private int money = 1000;
    public synchronized void banking() throws InterruptedException{
        if(money>0){
            Thread.sleep(1000);
            money-=1000;
            System.out.println("Current money: "+money);
        }else{
            System.out.println("Nothing");
        }
    }

    @Override
    public void run() {
        try {
            banking();
        } catch (InterruptedException ex) {
            Logger.getLogger(Banking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
