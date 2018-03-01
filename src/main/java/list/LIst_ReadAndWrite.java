package list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * 2017/6/14 14:34.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class LIst_ReadAndWrite {

    public static void main(String[] args) {

        // 初始化一个list，放入5个元素
        final List<Integer> list = new ArrayList<>();
        //final List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        // 线程一：通过Iterator遍历List
        final Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int item : list) {
                    System.out.println("----->" + item);
                    // 由于程序跑的太快，这里sleep了1秒来调慢程序的运行速度
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 线程二：remove一个元素
        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                // 由于程序跑的太快，这里sleep了1秒来调慢程序的运行速度
                try {
                    Thread.sleep(1000);
                   // one.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.remove(4);
                System.out.println("list.remove(4)");
            }
        });

        two.start();
        one.start();

    }

}
