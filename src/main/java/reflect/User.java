package reflect;

/**
 * 2016/8/19 10:59.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class User implements Cloneable ,Person{

    private String name = null;

    private Integer age = null;

    private Integer sex = null;

    public User() {
        System.err.println("user的无惨构造方法");
    }

    public User(String name, Integer age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void sayHello(){
        System.err.println("我是user里面的输出方法");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
