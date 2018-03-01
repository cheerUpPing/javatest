package threadlocal;

/**
 * threadLocalά��ÿ���̵߳�ֵ
 * 
 * @author elon
 *
 */
public class ThreadlocalTest {

	public static void main(String[] args) {
		//final���ñ���ָ��ĵ�ַ���䣬�������ݿ��Ա�
		final ThreadLocal<User> threadLocal = new ThreadLocal<User>(){
			//��ͬ���߳�ÿ�ε��û�ִ�еķ���
			@Override
			protected User initialValue() {
				return new User();
			}
		};
		User user = new User();
		System.out.println("�ʼ��user:"+user);
		threadLocal.set(user);
		Thread[] threads = new Thread[10];
		for(int i=0;i<10;i++){
			//System.out.println("---"+Thread.currentThread()+threadLocal.get());
			threads[i] = new Thread(){
				@Override
				public void run() {
					User u = threadLocal.get();
					if (u == null) {
						System.out.println("Ϊ�գ�׼������");
						threadLocal.set(new User());
					}
					System.out.println(""+Thread.currentThread()+threadLocal.get());
				}
			};
			threads[i].start();
		}
	}
	
}
