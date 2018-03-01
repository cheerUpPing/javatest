package atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicTest {

	private static Lock lock = new ReentrantLock();

	public static void pay() {
		try {
			lock.tryLock(1, TimeUnit.SECONDS);//?м????????????????????????
			// lock.lock();
			while (true) {
				System.out.println("????????????????" + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("??????ж??????" + Thread.currentThread().getName());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				AtomicTest.pay();
			}
		};
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				AtomicTest.pay();
			}
		};
		thread1.start();
		thread2.start();
		System.out.println("=================================================");
	}
}
