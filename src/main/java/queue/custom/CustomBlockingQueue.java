package queue.custom;

/**
 * 2017/6/14 17:14.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 自定义阻塞队列
 */
public class CustomBlockingQueue<T> {

    private int initSize = 10;

    private int realSize = 0;

    //队列满了
    private final Object fullLock = new Object();
    //队列空了
    private final Object emptyLock = new Object();

    private Object[] data = null;

    public CustomBlockingQueue(int initSize) {
        this.initSize = initSize;
        data = new Object[initSize];
    }

    public CustomBlockingQueue() {
        this(10);
    }

    /**
     * 存放元素
     *
     * @param e
     * @throws InterruptedException
     */
    public void put(T e) throws InterruptedException {
        //表示队列已经满了，那么就等待，等待队列取出
        if (realSize == initSize) {
            synchronized (fullLock) {
                fullLock.wait();
            }
        }
        data[realSize] = e;
        realSize = realSize + 1;
        synchronized (emptyLock) {
            emptyLock.notify();
        }
    }

    /**
     * 取元素
     *
     * @return
     * @throws InterruptedException
     */
    public T take() throws InterruptedException {
        if (realSize == 0) {
            synchronized (emptyLock) {
                emptyLock.wait();
            }
        }
        realSize = realSize - 1;
        T obj = (T) data[realSize];
        synchronized (fullLock) {
            fullLock.notify();
        }
        return obj;
    }
    public static void main(String[] args) {
        final CustomBlockingQueue<Integer> customBlockingQueue = new CustomBlockingQueue<>(4);
        Thread one = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        customBlockingQueue.put(i);
                        System.out.println("in:" + i);
                        i = i + 1;
                        sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread two = new Thread() {
            @Override
            public void run() {
                while (true){
                    try {
                        int k = customBlockingQueue.take();
                        System.out.println("out:" + k);
                        sleep(9000);
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
