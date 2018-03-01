package nio.client;

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

    public ClientReadThread(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        while (true) {
            int count = 0;
            try {
                count = selector.select();
                if (count == 0) {
                    continue;
                } else {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                    while (selectionKeyIterator.hasNext()) {
                        SelectionKey selectionKey = selectionKeyIterator.next();
                        if (selectionKey.isReadable()) {
                            //返回selectionKey对应的socketChannel
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            socketChannel.read(byteBuffer);
                            byteBuffer.flip();// 调用此方法为一系列通道写入或相对获取 操作做好准备
                            // 将字节转化为为UTF-16的字符串
                            String receivedString = Charset.forName("utf-8").newDecoder().decode(byteBuffer).toString();
                            // 控制台打印出来
                            System.out.println("client console: had already got msg from server:" + socketChannel.socket().getRemoteSocketAddress() + ":" + receivedString);
                            selectionKey.interestOps(SelectionKey.OP_READ);
                        }
                        selector.selectedKeys().remove(selectionKey);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
