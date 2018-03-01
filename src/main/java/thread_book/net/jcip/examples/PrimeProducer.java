package thread_book.net.jcip.examples;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * PrimeProducer
 * <p/>
 * Using interruption for cancellation
 *
 * @author Brian Goetz and Tim Peierls
 */
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                p = p.nextProbablePrime();
                //因为当队列满了，put就会导致当前线程阻塞，线程在阻塞时被中断时会抛出InterruptedException异常
                queue.put(p);
                System.out.println(p);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel() {
        interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        PrimeProducer primeProducer = new PrimeProducer(new LinkedBlockingQueue<>());
        primeProducer.start();
        TimeUnit.SECONDS.sleep(1);
        primeProducer.cancel();
    }
}
