package nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * 2017/3/2 9:18.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 服务端
 * 处理完的selectionKey要移除掉，要不然会重复进入
 * 客户端和服务端的链接是长链接
 */
public class Server {


    /**
     * 创建服务端
     *
     * @param port
     * @throws IOException
     */
    public static void openServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        Selector selector = Selector.open();

        int buffSize = 1024;//缓冲区1024个字节

        serverSocketChannel.bind(new InetSocketAddress(8083));

        serverSocketChannel.configureBlocking(false);
        //会返回一个selectionKey
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            if (selector.select() == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
            while (selectionKeyIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeyIterator.next();
                if (selectionKey.isValid() && selectionKey.isAcceptable()) {
                    //返回和客户端通信的通道 selectionKey.channel() 对应的通道
                    SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                    System.out.println(socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isValid() && selectionKey.isReadable()) {
                    //返回和客户端通信的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    System.out.println("==================" + socketChannel.hashCode());
                    ByteBuffer byteBuffer = ByteBuffer.allocate(buffSize);
                    int count = socketChannel.read(byteBuffer);
                    if (count == -1) {
                        socketChannel.close();
                    } else {
                        //由可写转换为可读状态
                        byteBuffer.flip();
                        String received = Charset.forName("utf-8").newDecoder().decode(byteBuffer).toString();

                        System.out.println("server console:from client msg:" + received + socketChannel.getRemoteAddress());

                        String send = "hello client,server has already got your msg:[" + received + "]";
                        socketChannel.write(ByteBuffer.wrap(send.getBytes("utf-8")));
                        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    }
                } else {

                }
                //移除已经处理完的selectionKey
                selectionKeys.remove(selectionKey);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        Server.openServer(8083);
    }
}
