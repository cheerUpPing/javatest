package nio.talk_project.client;

import com.alibaba.fastjson.JSON;
import nio.talk_project.entity.RequestEntity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * 2017/3/2 11:07.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 读取服务端返回的信息
 */
public class ClientReadThread implements Runnable {

    private Selector selector = null;

    public static int bufferSize = 1024;

    public ClientReadThread(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        while (true) {
            int selectCount = 0;
            try {
                selectCount = selector.select();
                if (selectCount == 0) {
                    continue;
                } else {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                    while (selectionKeyIterator.hasNext()) {
                        SelectionKey selectionKey = selectionKeyIterator.next();
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        if (selectionKey.isValid() && selectionKey.isReadable()) {
                            ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
                            int count = socketChannel.read(byteBuffer);
                            if (count == -1) {
                                socketChannel.close();
                            } else {
                                byteBuffer.flip();
                                String received = Charset.forName("utf-8").newDecoder().decode(byteBuffer).toString();
                                RequestEntity requestEntity = JSON.parseObject(received, RequestEntity.class);
                                System.out.println(requestEntity.getFrom() + " friend say --->: " + requestEntity.getBody());
                            }
                        }
                        selectionKeys.remove(selectionKey);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
