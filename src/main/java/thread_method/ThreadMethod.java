package thread_method;

/**
 * ��ͬ�̷߳���ͬһ�������ͬһ����������������ı����Ǵ�����ݵģ���������Ǿ�̬������ô�ù���һ��
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
