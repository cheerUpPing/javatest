package cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 2017/2/21 15:36.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class MethodHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before in methodHandler.....");
        proxy.invokeSuper(obj, args);
        System.out.println("end in methodHandler.....");
        return null;
    }

    public static void main(String[] args) {
        String tem = "周日007,1//周日116,3//周日117,1//周日118,3//周日119,0R//周日120,0R//周日121,0R";
        String[] tems = tem.split("//");
        System.out.println(tems.length);
    }
}
