package classloader;

/**
 * 2016/8/26 11:26.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class ClassTest {


    public static void main(String[] args) {
        System.out.println(ClassTest.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@592fa617
        System.out.println(ClassTest.class.getClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@47415dbf
        //extclassloader的父classloader实际上是bootstrap class loader，但是它不是java中的class loader所以取到的是null
        System.out.println(ClassTest.class.getClassLoader().getParent().getParent());//null
    }
}
