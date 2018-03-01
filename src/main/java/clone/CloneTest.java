package clone;

/**
 * 2016/8/19 11:32.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("1",1,1);
        System.out.println("刚创建时对象："+user.hashCode()+user);
        user.setName("2");
        user.setAge(1);
        user.setSex(1);
        System.out.println("修改后对象："+user.hashCode()+user);
        User t = (User) user.clone();//克隆，浅克隆
        user.setName("3");
        System.out.println("克隆后的对象："+t.hashCode()+t);
    }

}
