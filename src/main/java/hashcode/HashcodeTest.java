package hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * object对象中的 public boolean equals(Object obj)，对于任何非空引用值 x 和 y，当且仅当 x 和 y 引用同一个对象时，此方法才返回 true；
 * 注意：当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。如下：
 * (1)当obj1.equals(obj2)为true时，obj1.hashCode() == obj2.hashCode()必须为true
 * (2)当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false
 * 如果不重写equals，那么比较的将是对象的引用是否指向同一块内存地址，重写之后目的是为了比较两个对象的value值是否相等。特别指出利用equals比较八大包装对象
 * （如int，float等）和String类（因为该类已重写了equals和hashcode方法）对象时，默认比较的是值，在比较其它自定义对象时都是比较的引用地址
 *
 * @author elon
 */
public class HashcodeTest {

    public static void main(String[] args) {
        Map<Name, User> map = new HashMap<>();
        Name name1 = new Name("123456");
        Name name2 = new Name("123456");
        Name name3 = new Name("1234567");
        User user1 = new User();
        user1.setName("xiaoming");
        user1.setSex(1);
        User user2 = new User();
        user2.setName("xiaohong");
        user2.setSex(0);
        map.put(name1, user1);
        map.put(name3, user2);
        System.out.println(map.size());
    }


}


