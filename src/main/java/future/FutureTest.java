package future;

import reflect.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 2017/8/31 9:08.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * Future FutureTask Callable Runnable
 * 之间的关系
 */
public class FutureTest {

    /**
     * Callable  Future  ExecutorService 结合使用
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable callable = new Callable<User>() {
            @Override
            public User call() throws Exception {
                System.out.println("调用call..." + Thread.currentThread().getName());
                Thread.sleep(3000);
                return new User("xiaoming", 21, 0);
            }
        };
        Future<User> future = executorService.submit(callable);
        System.out.println(sdf.format(new Date()));
        //这句话 阻塞直到获取到结果,runnable是没有返回值的
        Object user = future.get();
        System.out.println(sdf.format(new Date()) + user);
        //关闭线程池
        executorService.shutdown();
    }

    /**
     * FutureTask  Callable  ExecutorService 结合使用
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main3(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask(callable);
        executorService.submit(futureTask);
        //futureTask.run();main函数运行
        //通过future自身来获取返回的结果
        Integer result = futureTask.get();
        System.out.println(result);
        //关闭线程池
        executorService.shutdown();
    }

    /**
     * FutureTask  Runnable  ExecutorService 结合使用
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main2(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ExecutorService executorService = Executors.newSingleThreadExecutor();


    }


}

class MyCallable implements Callable<Integer> {
    private int sum = 0;

    @Override
    public Integer call() throws Exception {
        System.out.println("调用call...." + Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            sum = sum + i;
        }
        Thread.sleep(3000);
        return sum;
    }
}
