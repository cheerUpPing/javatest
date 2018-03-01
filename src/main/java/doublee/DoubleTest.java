package doublee;

/**
 * 2017/1/9 9:25.
 * <p>
 * Email: cheerUpPing@163.com
 * double/float 要计算才会出现小数不精确的问题，声明小数是不会有进度问题的，因为这两者设计的目的是为了快速近视计算设计的
 */
public class DoubleTest {


    public static void main(String[] args) {
        double a = 1.0;
        double b = 0.11;
        double c = 0.61;
        double d = a - b;
        System.out.println(d);
        System.out.println(c);
        System.out.println("==================================");
    }
}
