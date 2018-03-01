package invokeHandler;

import java.lang.reflect.Proxy;

/**
 * 2016/8/22 16:43.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class Client {

    public static void main(String[] args) {
        //创建真实对象
        int i=0;
        Subject really = new RealSubject();
        //handler关联真实对象
        ProxyHandler proxyHandler = new ProxyHandler(really);
        //生成代理对象
        Subject subject = (Subject) Proxy.newProxyInstance(proxyHandler.getClass().getClassLoader(),really.getClass().getInterfaces(),proxyHandler);
       // System.out.println(subject);
        System.out.println(i);
        System.out.println(subject.getClass().getName());
        subject.rent();

    }
}
