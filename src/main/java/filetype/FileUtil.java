package filetype;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 2017/10/18 16:23.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class FileUtil {
    /**
     * Constructor
     */
    private FileUtil() {
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @param src
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 得到文件头
     *
     * @param filePath 文件路径
     * @return 文件头
     * @throws IOException
     */
    private static String getFileHead(String filePath) throws IOException {

        byte[] b = new byte[28];

        InputStream inputStream = null;

        try {
            //获取前28个字节
            inputStream = new FileInputStream(filePath);
            inputStream.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return bytesToHexString(b);
    }

    /**
     * 获取文件头
     *
     * @param src
     * @return
     */
    public static String getFileHead(byte[] src) {
        return bytesToHexString(get8Byte(src));
    }

    /**
     * 获取前8个字节
     *
     * @param bytes
     * @return
     */
    private static byte[] get8Byte(byte[] bytes) {
        byte[] result = new byte[8];
        for (int i = 0; i < 8; i++) {
            result[i] = bytes[i];
        }
        return result;
    }

    /**
     * 判断文件类型
     *
     * @param filePath 文件路径
     * @return 文件类型
     */
    public static FileType getType(String filePath) throws IOException {

        String fileHead = getFileHead(filePath);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
        fileHead = fileHead.toUpperCase();

        FileType[] fileTypes = FileType.values();

        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "d:/a.BMP";
        InputStream inputStream = new FileInputStream(filePath);
        System.out.println(getType(filePath));
    }
}
