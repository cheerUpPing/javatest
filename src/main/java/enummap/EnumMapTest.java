package enummap;

import java.util.*;

/**
 * 2016/9/7 11:24.
 * <p>
 * Email: cheerUpPing@163.com
 * EnumMap是专门为 枚举 类型量身定做的 map
 * 适用于：map确定的数量，比如：错误信息定义
 */
public class EnumMapTest {


    private enum ErrorCode {
        _0001,
        _0002
    }

    private static Map map = new EnumMap<ErrorCode, String>(ErrorCode.class);

    static {
        map.put(ErrorCode._0001, "信息错误!");
        map.put(ErrorCode._0002,"操作失败!");
    }


    public static void main(String[] args) {
        System.out.println(EnumMapTest.map.get(ErrorCode._0001));
        Set<Map.Entry> entries = map.entrySet();
        for (Map.Entry entry : entries){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        List list = new ArrayList();

    }

}
