package threadlocal;

/**
 * threadLocal维护每个线程的值
 * 
 * @author elon
 *
 */
public class ThreadlocalTest {

	public static void main(String[] args) {
		//final引用变量指向的地址不变，但是内容可以变
		final ThreadLocal<User> threadLocal = new ThreadLocal<User>(){
			//不同的线程每次调用会执行的方法
			@Override
			protected User initialValue() {
				return new User();
			}
		};
		User user = new User();
		System.out.println("最开始的user:"+user);
		threadLocal.set(user);
		Thread[] threads = new Thread[10];
		for(int i=0;i<10;i++){
			//System.out.println("---"+Thread.currentThread()+threadLocal.get());
			threads[i] = new Thread(){
				@Override
				public void run() {
					User u = threadLocal.get();
					if (u == null) {
						System.out.println("为空，准备创建");
						threadLocal.set(new User());
					}
					System.out.println(""+Thread.currentThread()+threadLocal.get());
				}
			};
			threads[i].start();
		}
	}
	
}
