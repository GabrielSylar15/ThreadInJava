/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThread;

import java.math.BigDecimal;

/**
 *
 * @author hapt61
 */
public class SuperCaculate implements Runnable {

    BigDecimal rs = new BigDecimal("1");

    @Override
    public void run() {
        for (long i = 1; i < 100000; i++) {
            rs = rs.add(rs.multiply(new BigDecimal(i)));
        }
        System.out.println("Result: " + rs);
    }

    public void SyncCal() {
        for (long i = 1; i < 100000; i++) {
            rs = rs.add(rs.multiply(new BigDecimal(i)));
        }
        System.out.println("Result: " + rs);
    }

    public BigDecimal getRs() {
        return rs;
    }

}
