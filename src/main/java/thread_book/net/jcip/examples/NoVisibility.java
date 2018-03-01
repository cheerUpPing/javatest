package thread_book.net.jcip.examples;

/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 *
 * @author Brian Goetz and Tim Peierls
 */

public class NoVisibility {
    private static volatile boolean ready;
    private static volatile int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                //yield()让当前线程进去可运行状态，暂时让出cpu[不会释放相关锁]
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++)
            new ReaderThread().start();
        ready = true;
        number = 42;
    }
}
