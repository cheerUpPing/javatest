package extend.chain;

/**
 * 2017/1/4 15:54.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 1.克隆是产生一个一模一样的新的对象
 * 2.由于clone是protected的本地方法，所以要重写她才可以使用
 */
public class Parent implements Cloneable {

    private Parent() {
        System.out.println("-------------------------i am is father,no canshu" + this);
    }

    public Parent(int a) {
        System.out.println("------------------i am is father,with canshu" + a + this);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
