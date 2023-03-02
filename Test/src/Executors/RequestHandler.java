/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Executors;

/**
 *
 * @author hapt61
 */
public class RequestHandler implements Runnable {

    String name;

    public RequestHandler(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Starting process "+name);
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " Finish process "+name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
