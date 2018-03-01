package enumm;

/**
 * 2017/1/4 14:39.
 * <p>
 * Email: cheerUpPing@163.com
 *
 * 通过枚举来获取单利
 */
public class XYZUtil {

    /**
     * 私有构造函器
     */
    private XYZUtil() {

    }

    /**
     * 枚举是静态的
     */
    private enum XYZSigle {
        INSTANCE;//有几个枚举成员就会实例化几次

        private XYZUtil xyzUtil;

        private XYZSigle() {

            System.out.println("---------------------");
            xyzUtil = new XYZUtil();
        }

        public XYZUtil getSigle() {
            return xyzUtil;
        }


    }

    public static void main(String[] args) {
        XYZUtil xyzUtil = XYZSigle.INSTANCE.getSigle();
        XYZUtil xyzUtil1 = XYZSigle.INSTANCE.getSigle();


        System.out.println(xyzUtil == xyzUtil1);
    }

}
