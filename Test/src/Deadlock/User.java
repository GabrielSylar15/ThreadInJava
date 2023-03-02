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
public class User implements Runnable{
    BankAccount bankAccount;

    public User(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    @Override
    public void run() {
        sendNotify();
    }
    
        
    public void sendNotify(){
        System.out.println("User");
        System.out.println("Waitig for bankaccount");
        bankAccount.deposit();
    }
}
