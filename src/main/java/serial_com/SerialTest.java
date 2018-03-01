package serial_com;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;

/**
 * 2017/9/21 15:01.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class SerialTest {
    /**
     * 检测串口是否存在
     *
     * @param comm
     * @param printIp
     * @return
     */
    private static boolean isExist(String printIp, String comm) {
        boolean isExist = true;
        CommPortIdentifier commPortIdentifier = null;
        try {
            commPortIdentifier = CommPortIdentifier.getPortIdentifier(comm);
            if (commPortIdentifier == null) {
                isExist = false;
            }
        } catch (NoSuchPortException e) {
            isExist = false;
            //LogUtil.info(SerialUtil.class, "初始化串口", "票机" + printIp + "串口【" + comm + "】不存在," + LogUtil.getStackTrace(e));
        }
        return isExist;
    }


    public static void main(String[] args) throws Exception {
        //SerialPort sendPort = SerialTool.openPort("COM12",9600);
        SerialPort revicedPort = SerialTool.openPort("COM11", 9600);
        SerialTool.addListener(revicedPort, new SerialListener());

    }
}
