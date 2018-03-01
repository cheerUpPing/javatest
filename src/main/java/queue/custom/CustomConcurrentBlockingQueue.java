package queue.custom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2017/6/14 17:45.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 自定义队列--Lock机制
 */
public class CustomConcurrentBlockingQueue<T> {

    private int initSize = 10;

    private int realSize = 0;

    private Object[] data = null;

    private Lock lock = new ReentrantLock();

    private Condition fullCondition = lock.newCondition();

    private Condition emptyCondition = lock.newCondition();

    public CustomConcurrentBlockingQueue() {
        this(10);
    }

    public CustomConcurrentBlockingQueue(int initSize) {
        this.initSize = initSize;
        data = new Object[initSize];
    }

    /**
     * 存值
     *
     * @param e
     * @throws InterruptedException
     */
    public void put(T e) throws InterruptedException {
        try {
            lock.lock();
            System.out.println("excute put");
            if (realSize == initSize) {
                System.out.println("put-->readly to wait");
                fullCondition.await();
                System.out.println("put-->wait close");
            }
            data[realSize] = e;
            realSize = realSize + 1;
            emptyCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 取值
     *
     * @return
     * @throws InterruptedException
     */
    public T take() throws InterruptedException {
        try {
            lock.lock();
            System.out.println("excute take");
            if (realSize == 0) {
                System.out.println("take-->readly to wait");
                emptyCondition.await();
                System.out.println("take-->wait close");
            }
            realSize = realSize - 1;
            T obj = (T) data[realSize];
            fullCondition.signal();
            return obj;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final CustomConcurrentBlockingQueue<Integer> userCustomConcurrentBlockingQueue = new CustomConcurrentBlockingQueue<>(4);
        Thread one = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        userCustomConcurrentBlockingQueue.put(i);
                        System.out.println("in:" + i);
                        i = i + 1;
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread two = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int k = userCustomConcurrentBlockingQueue.take();
                        System.out.println("out:" + k);
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        one.start();
        two.start();
    }

}
