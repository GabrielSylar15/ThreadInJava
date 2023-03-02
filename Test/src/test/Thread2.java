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
public class Thread2 extends Thread {

    @Override
    public synchronized void run() {
        System.out.println();
        for (int x = 1; x <= 3; x++) {
            System.out.println(x + " Thread2 name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
