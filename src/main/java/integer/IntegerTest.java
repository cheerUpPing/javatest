package integer;

/**
 * 8��������ͻ��Զ�װ�����
 * 
 * @description
 *
 * @author elon
 *
 * @date 2016��7��15�� ����11:32:51
 */
public class IntegerTest {

	public static void main(String[] args) {
		int a = Integer.parseInt("1");
		System.out.println(a);
		long b = Long.parseLong("2");// 8��������ͻ��Զ�װ�����
		System.out.println(b);
		if ((Integer)a instanceof Integer) {
			System.out.println("-----------------");
		}
	}

}
