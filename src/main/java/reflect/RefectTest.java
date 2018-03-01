package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 2016/8/22 11:31.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class RefectTest {


    public static void main(String[] args) throws Exception{
        Class<User> userClass = (Class<User>) Class.forName(User.class.getName());
        User user = userClass.newInstance();//这是默认调用无惨构造函数，如果无惨构造函数不存在的话就会报错
        System.err.println(""+user);

        System.err.println("----------构造函数创建对象-----------------");
        //只能获取到非private类型的构造函数
        Constructor<?> constructors[] = userClass.getConstructors();
        //只能获取到非private类型的字段
        Field fields[] = userClass.getFields();

        User user0 = (User) constructors[0].newInstance();
        User user1 = (User) constructors[1].newInstance("反射，构造函数实例化",2,2);
        System.err.println("------------------------------------------");

        System.err.println("--------------获取实现的接口----------------");
        Class interfaces[] = userClass.getInterfaces();
        for(Class interfac : interfaces){
            System.err.println(interfac.getName());
        }
        System.err.println("------------------------------------------");
        System.err.println("--------------获取继承的父类----------------");
        //object是任何类的父类
        Class superr = userClass.getSuperclass();
        System.err.println(superr.getName());
        System.err.println("------------------------------------------");
        System.err.println("--------------方法调用----------------");
        Method method = userClass.getMethod("sayHello");
        method.invoke(userClass.newInstance());
        System.err.println("------------------------------------------");
        System.err.println("--------------字段赋值----------------");
        //得到在该类声明的字段，public protected default private
        Field fieldss[] = userClass.getDeclaredFields();
        Field field = userClass.getDeclaredField("name");
        User user2 = userClass.newInstance();
        field.setAccessible(true);//这里设置可见性为true，否则会报错：private
        field.set(user2,"xxx");
        Method methods[] = userClass.getDeclaredMethods();
        System.err.println("--------------------不同类的类加载器,appClassLoader----------------------");
        ClassLoader userClassLoader = User.class.getClassLoader();
        ClassLoader refectClassLoader = RefectTest.class.getClassLoader();
        System.err.println("------------------------------------------");



    }
}
