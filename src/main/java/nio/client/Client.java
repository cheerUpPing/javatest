package nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * 2017/3/2 10:45.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 客户端
 */
public class Client {


    /**
     * 创建客户端
     *
     * @param hostName
     * @param port
     * @throws IOException
     */
    public static void connectServer(String hostName, int port) throws IOException {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(hostName, port));

        Selector selector = Selector.open();

        socketChannel.configureBlocking(false);

        socketChannel.register(selector, SelectionKey.OP_READ);

        Scanner scanner = new Scanner(System.in);
        Runnable read = new ClientReadThread(selector);
        Thread thread = new Thread(read);
        thread.start();
        while (scanner.hasNextLine()) {
            String send = scanner.nextLine();
            System.out.println("client console:ready to send msg:" + send);
            socketChannel.write(ByteBuffer.wrap(send.getBytes("utf-8")));
        }
    }


    public static void main(String[] args) throws IOException {

        Client.connectServer("127.0.0.1", 8083);
    }


}
