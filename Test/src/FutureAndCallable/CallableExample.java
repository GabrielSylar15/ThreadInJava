/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FutureAndCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author hapt61
 */
public class CallableExample {

    /*
    Sources:
    https://viblo.asia/p/khai-niem-threadpool-va-executor-trong-java-gAm5yXNwldb
    https://viblo.asia/p/lap-trinh-da-luong-voi-completablefuture-trong-java-8-6J3ZgBMLKmB
    https://gpcoder.com/3565-lap-trinh-da-luong-voi-callable-va-future-trong-java/
     */
    public static void main(String[] args) {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Callable<Integer> callable;
        Future<Integer> future;
        for (int i = 1; i <= 10; i++) {
            callable = new CallableWorker(i);

            // submit Callable tasks to be executed by thread pool
            future = executor.submit(callable);

            // add Future to the list, we can get return value using Future
            list.add(future);
        }

        // shut down the executor service now
        executor.shutdown();

        // Wait until all threads are finish
        while (!executor.isTerminated()) {
            // Running ...
        }

        int sum = 0;
        for (Future<Integer> f : list) {
            try {
                sum += f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finished all threads: ");
        System.out.println("Sum all = " + sum);
    }
}
