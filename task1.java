package thread;

import java.util.concurrent.CountDownLatch;

public class task1 implements Runnable{
	private String name;
	private CountDownLatch _latch;
	public task1(String name, CountDownLatch _latch) {
		this.name = name;
		this._latch = _latch;
	}
	public task1(String name) {
		this.name = name;
	}
	
	

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
				System.out.println(name+"-"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		_latch.countDown();
		
	}

}
