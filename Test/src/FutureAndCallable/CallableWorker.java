/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FutureAndCallable;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author hapt61
 */
public class CallableWorker implements Callable<Integer> {

    private int num;
    private Random ran;

    public CallableWorker(int num) {
        this.num = num;
        this.ran = new Random();
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(ran.nextInt(10) * 1000);
        int result = num * num;
        System.out.println("Complete: " + num);
        return result;
    }

}
