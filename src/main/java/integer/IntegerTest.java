package integer;

/**
 * 8大基本类型会自动装箱拆箱
 * 
 * @description
 *
 * @author elon
 *
 * @date 2016年7月15日 上午11:32:51
 */
public class IntegerTest {

	public static void main(String[] args) {
		int a = Integer.parseInt("1");
		System.out.println(a);
		long b = Long.parseLong("2");// 8大基本类型会自动装箱拆箱
		System.out.println(b);
		if ((Integer)a instanceof Integer) {
			System.out.println("-----------------");
		}
	}

}
