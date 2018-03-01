package clone;

/**
 * 2016/8/19 10:59.
 * <p>
 * Email: cheerUpPing@163.com
 */
public final class User implements Cloneable{

    private String name = null;

    private Integer age = null;

    private Integer sex = null;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public User(String name, Integer age, Integer sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public User() {

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
