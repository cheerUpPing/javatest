package cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * 2017/2/21 15:37.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class MyTest {

    public static void main(String[] args) {

        MethodHandler methodHandler = new MethodHandler();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Programmer.class);

        enhancer.setCallback(methodHandler);

        Programmer proxy = (Programmer) enhancer.create();

        proxy.code();
        System.out.println("end....");

    }
}
