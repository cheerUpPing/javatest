/**
 * 2016/8/31 10:21.
 * <p>
 * Email: cheerUpPing@163.com
 * string  stringBuilder stringBuffer
 * 包装类都是一样，作为形参都是一份拷贝
 */
public class StringBuildTest {

    private static Integer a = 1;

    public static void changeStr(Integer str){


        str = a;
        System.out.println(str);
    }

    /**
     * 不定长度参数，在方法和构造函数都可以
     *
     * @param strs
     */
    public StringBuildTest(String... strs){

    }

    public static void main(String[] args) {

        Object object = new Object();

        try {
            synchronized (object){
                object.wait();//当前线程释放锁，如果开始没有获取到锁，就调用这个方法那么就报异常
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("====================");

    }

    /**
     * 方法名和参数是方法的签名
     *
     */
    public void myTest(){

    }
    public int myTest(int i){
        return 0;
    }


}
