package future;

import reflect.User;

import java.util.concurrent.*;

/**
 * 2017/9/1 16:28.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * CompletionService提交多个任务，把返回的future存放到queue[默认的是LinkedBlockingQueue]里面
 */
public class ExecutorCompletionServiceTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<User> completionService = new ExecutorCompletionService<>(executor);
        for (int i = 90; i < 100; i++) {
            Callable<User> callable = new Mycallable(i);
            completionService.submit(callable);
        }
        for (int i = 90; i < 100; i++) {
            Future<User> future = completionService.take();
            User user = future.get();
            System.out.println(user);
        }
        //关闭线程池线程--->关闭jvm虚拟机
        executor.shutdown();
    }


}

class Mycallable implements Callable<User> {

    private int age;

    public Mycallable(int age) {
        this.age = age;
    }

    @Override
    public User call() throws Exception {
        System.out.println("current thread : " + Thread.currentThread().getName());
        Thread.sleep(1000);
        return new User("xiaoming", age, age % 2);
    }
}
