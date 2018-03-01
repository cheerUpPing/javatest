package readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 2016/8/29 15:45.
 * <p>
 * Email: cheerUpPing@163.com
 *
 * 读写锁测试
 */
public class ReadwritelockTest {

    public static void main(String[] args) {

        //读写锁
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        //读锁
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        //写锁
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    }

}
