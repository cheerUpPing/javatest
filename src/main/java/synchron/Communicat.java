package synchron;

import static java.lang.Thread.sleep;

/**
 * 2017/5/25 11:14.
 * <p>
 * Email: cheerUpPing@163.com
 *
 * syn普通方法--当前对象锁
 * sync class对象--类对象锁
 * sync 静态方法--类对象锁
 * sleep 不释放锁
 * 线程的状态：created -- runnable -- running -- blocked -- dead
 */
public class Communicat {

    public synchronized static void say() throws InterruptedException {
        while (true){
            System.out.println("static----------------------->");
            sleep(1000);
        }
    }

    public void sayy() throws InterruptedException {
        synchronized (Communicat.class){
            while (true){
                System.out.println("class----------------------->");
                sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new Thread(){
            @Override
            public void run() {
                try {
                    Communicat.say();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread b = new Thread(){
            @Override
            public void run() {
                Communicat communicat = new Communicat();
                try {
                    communicat.sayy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        b.start();
        a.start();

    }


}
