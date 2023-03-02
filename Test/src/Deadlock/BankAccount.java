/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Deadlock;

/**
 *
 * @author hapt61
 */
public class BankAccount implements Runnable{

    @Override
    public void run() {
        deposit();
    }
    
    public void deposit(){
        System.out.println("BankAccount");
    }
    
}
