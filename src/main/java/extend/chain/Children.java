package extend.chain;

/**
 * 2017/1/4 15:55.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 子类的实例化，会同时实例化父类，所以父类必须有对应的构造函数
 */
public class Children extends Parent {

    public Children() {
        super(3);
        System.out.println("---------------i am children" + this);
    }
}
