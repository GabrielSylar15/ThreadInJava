package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
	private static CountDownLatch _latch;
	public static void main(String[] args) throws InterruptedException {
//		Thread t1 = new Thread(new task1("A"));
//		Thread t2 = new Thread(new task1("B"));
//		Thread t3 = new Thread(new task1("C"));
//		t1.start();
//		t3.start();
//		t2.start();
		List<Thread> list = new ArrayList<>();
		ExecutorService pool = Executors.newFixedThreadPool(6);
		_latch = new CountDownLatch(12);
		for (int i = 0; i < 12; i++) {
			Thread req = new Thread(new task1(i+"---", _latch));
			list.add(req);
			pool.execute(req);
		}
//		aw
//		for (Thread thread : list) {
//			thread.join();
//		}
		pool.shutdown();
		try {
			_latch.await();
			System.out.println("Vinhhhhhhhhhh");
		} catch (InterruptedException E) {
			   // handle
		}

	}
}
