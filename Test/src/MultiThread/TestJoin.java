/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThread;

/**
 *
 * @author hapt61
 */
public class TestJoin {
//  Thread.join() đợi thread thực hiện xong mới làm các câu lệnh sau nó
//  Ở dòng 21 đợi thread.join chạy xong rồi chạy tới thread2.join rồi mới chạy tới sout
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Thread thread = new Count();
        Thread thread2 = new Count2();
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("Finish Task!");
    }
}
