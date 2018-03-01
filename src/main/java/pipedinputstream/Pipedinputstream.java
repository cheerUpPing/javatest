package pipedinputstream;

import java.util.UUID;

/**
 * 2016/9/8 16:10.
 * <p>
 * Email: cheerUpPing@163.com
 * 管道流测试类
 */
public class Pipedinputstream {


    public static void main(String[] args) throws Exception {

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-","");
        System.out.println(uuid);

        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.fromString("123").toString());
        }


    }

}
