package thread_method;

/**
 * 不同线程访问同一个对象的同一个方法，方法里面的变量是创建多份的，但是如果是静态变量那么久公用一份
 *
 * @author elon
 */
public class ThreadMethod extends Thread {


    public static void main(String[] args) {
        ThreadMethod a = new ThreadMethod();
        a.start();
    }

    public void run() {
        while (true) {
            System.out.println("----------------------->" + Thread.currentThread().getName());
        }
    }

}
