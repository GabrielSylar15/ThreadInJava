/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author hapt61
 */
public class main {
    public static void main(String[] args) {
        Banking banking = new Banking();
        Thread t1 = new Thread(banking);
        Thread t2 = new Thread(banking);
        t1.start();
        t2.start();
    }
}
