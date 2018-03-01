package invokeHandler;

/**
 * 2016/8/22 16:41.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class RealSubject implements Subject{

    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
