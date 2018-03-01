package list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 2016/9/9 10:32.
 * <p>
 * Email: cheerUpPing@163.com
 * 普通的list/set/map 在 遍历和修改不能同时进行，否则会报线程修改异常
 * 必须用copyOn*类，因为它在修改的时候回锁住并提供出一个新的副本出来
 */
public class CopyOnWriteArrayListTest {


    public static void main(String[] args) throws InterruptedException {

        //final List<String> list = new ArrayList<>();
        final List<String> list = new CopyOnWriteArrayList<>();//rb69691
        //final Set<String> set = new HashSet<>();
        final Set<String> set = new CopyOnWriteArraySet<>();

        final Map<String,String> map = new HashMap<>();
        list.add("a");
        list.add("b");
        list.add("c");
        set.add("a");
        set.add("b");
        set.add("c");
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        Thread thread = new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    list.add(++count + "");
                    set.add(++count+"");
                    map.put(++count+"",count+"");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.currentThread().sleep(3);
        for (String tem : list){
            //System.out.println("List的hashcode"+list.hashCode());
            //System.out.println(tem);
        }
        for (String tem : set){
            //System.out.println("set的hashcode" + set.hashCode());
            //System.out.println(tem);
        }
        for (;;){
            Set<Map.Entry<String,String>> entries = map.entrySet();
            for (Map.Entry<String,String> entry : entries){
                System.out.println("key:"+entry.getKey()+"val:"+entry.getValue());
                System.out.println(entries.hashCode());
            }
        }


    }
}
