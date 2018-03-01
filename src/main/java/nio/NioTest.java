package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 2016/12/28 13:49.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class NioTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\test.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get());
            //byteBuffer.compact();
        }
        System.out.println("------------------------------");
    }
}
