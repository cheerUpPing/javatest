package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述:
 * @时间:2016/12/25 22:30
 * @邮箱:cheerUpPing@163.com
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        String[] arr = new String[3];
        list.toArray(arr);
        for (String ar : arr) {
            System.out.println(ar);
        }
        System.out.println("---------------");
    }
}
