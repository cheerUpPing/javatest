package invokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 2016/8/22 16:37.
 * <p>
 * Email: cheerUpPing@163.com
 *
 * 用于动态代理
 */
public class ProxyHandler implements InvocationHandler {

    //这个是真实的对象
    private Object object;

    public ProxyHandler(Object object){
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("调用之前----"+method.getName());

        method.invoke(object,args);

        System.out.println("调用之后----");

        return null;
    }
}
