package threadvariable;

public class ThreadMain {

	public void test() {
		User user = null;
		if (user == null) {
			user = new User();
			System.out.println("���󲻴��ڣ�Ҫ��������" + user.hashCode());
		} else {
			System.out.println("������ڣ����ô�������" + user.hashCode());
		}
	}

	public static void main(String[] args) {
		final ThreadMain a = new ThreadMain();
		while (true) {
			new Thread() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					a.test();
				}
			}.start();
		}
	}

}
