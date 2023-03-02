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
public class main {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
//  Performance của Asyn và không Asyn là như nhau tuy nhiên Asyn tốt hơn vì reponse kết quả DoSomethingInProcessTime ngay khi hàm đó thực hiện xong

//------------------Test performance of async--------------        
//        SuperCaculate cal = new SuperCaculate();
//        Thread thread = new Thread(cal);
//        DoSomethingInProcessTime thread2 = new DoSomethingInProcessTime();
//        thread.start();
//        thread2.start();
//        thread2.join();
//        thread.join();

//------------------Test performance of sync--------------    
//        SuperCaculate superCal = new SuperCaculate();
//        DoSomethingInProcessTime doSt = new DoSomethingInProcessTime();
//        superCal.SyncCal();
//        doSt.SyncCal();

//--------------Asyn with return values (not void)----------------
        SuperCaculate cal = new SuperCaculate();
        SupperMul2 cal2 = new SupperMul2();
        Thread thread1 = new Thread(cal);
        Thread thread2 = new Thread(cal2);
        thread1.run();
        thread2.run();
        BigDecimal result = cal.getRs().add(cal2.getRs());
        System.out.println("Result: "+result);
        
//--------------Sync with same caculation in before function (i>100000)+(i>100000)---------
//        BigDecimal rs = new BigDecimal("1");
//        BigDecimal rs2 = new BigDecimal("1");
//        for (long i = 1; i < 100000; i++) {
//            rs = rs.add(rs.multiply(new BigDecimal(i)));
//        }
//        for (long i = 1; i < 100000; i++) {
//            rs2 = rs2.add(rs2.multiply(new BigDecimal(i)));
//        }
//        System.out.println("Result: " + rs.add(rs2));

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
                System.out.println("he");
        System.out.println(totalTime);
    }
}
