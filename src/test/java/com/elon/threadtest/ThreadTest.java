package com.elon.threadtest;

/**
 * 2017/7/14 14:20.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class ThreadTest {

    public static int allCount = 50;

    public static volatile int currentCount = 0;

    public static void main(String[] args) throws InterruptedException {

        Object commonLock = new Object();
        int mainThreadCount = 20;
        int childrendThreadCount = 10;

        ChildrendThread childrendThread = new ChildrendThread(commonLock, childrendThreadCount);
        childrendThread.start();


        synchronized (commonLock) {
            for (int i = 0; currentCount < allCount; i++) {
                System.out.println("mian------------->" + i+"--------------------->"+ThreadTest.currentCount);
                if (i == mainThreadCount) {
                    i = 0;
                    currentCount = currentCount + 1;
                    commonLock.notify();
                    commonLock.wait();
                }
            }

        }
    }

}

class ChildrendThread extends Thread {

    private Object object;

    private int count;

    public ChildrendThread(Object object, int count) {
        this.object = object;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (object) {
            for (int i = 0; ThreadTest.currentCount < ThreadTest.allCount; i++) {
                System.out.println("childrend------------->" + i+"--------------------->"+ThreadTest.currentCount);
                if (i == count) {
                    i = 0;
                    try {
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
