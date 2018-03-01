package nio.talk_project.entity;

import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2017/3/2 15:44.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 常量类
 */
public class Contants {

    /**
     * 服务器端，保存userid和与客户端通信的socketChannel
     */
    public static Map<String, SocketChannel> socketChannelMap = new ConcurrentHashMap<String, SocketChannel>();

    public static class Error{

        public static String GENERAL_ERROR = "-1";
        public static String GENERAL_ERROR_MSG = "通用错误";

        public static String FRIEND_NOT_EXIST = "0001";
        public static String FRIEND_NOT_EXIST_MSG = "好友不存在!";

    }

    public static void main(String[] args) {
       Integer a = null;
        System.out.println(a == null);
    }

}
