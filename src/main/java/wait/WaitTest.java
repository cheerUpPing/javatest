package wait;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 2016/8/26 16:14.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class WaitTest {

    public static void main(String[] args) {


        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();

        Object object = new Object();
        System.out.println(object);
        int threadLength = 10;
        MyRunable myRunable = new MyRunable(object);
        Thread threads[] = new Thread[threadLength];//声明一个线程数组
        for (int i = 0; i < threadLength; i++) {
            threads[i] = new Thread(myRunable);//线程数组初始化
        }
        for (int i = 0; i < threadLength; i++) {
            threads[i].start();//启动线程
        }

    }


}

class MyRunable implements Runnable {

    private Object object = null;
    private int i = 0;

    public MyRunable(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            object.notifyAll();
            object.wait();//当前线程等待，并且关闭这个对象的监控器(释放锁的意思)，只有重新获的到该对象的监控器(获取到锁)才可以继续执行
            //如果该对象的监控器已经关闭，再次调用wait方法的话就会报监控器状态异常
            System.err.println("正常执行" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("异常" + Thread.currentThread().getName());
            i++;
        }

    }
}
