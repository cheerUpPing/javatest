package sjyy.com;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.util.concurrent.TimeUnit;

/**
 * 2017/9/11 11:17.
 * <p>
 * Email: cheerUpPing@163.com
 * 说明:
 * BI Break interrupt 通讯中断
 * FE Framing error 帧错误
 * CD Carrier detect 载波侦听
 * OE Overrun error 溢位错误
 * CTS Clear to send 清除发送
 * PE Parity error 奇偶检验错误
 * DSR Data set ready 数据设备准备好
 * RI Ring indicator 响铃侦测
 * DATA_AVAILABLE 串口中的可用数据
 * OUTPUT_BUFFER_EMPTY 输出缓冲区已清空
 */
public class CommListener implements SerialPortEventListener {
    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SerialPort serialPort = (SerialPort) serialPortEvent.getSource();
        if (serialPort.isRI()){
            System.out.println("####################");
        }
        switch (serialPortEvent.getEventType()) {
            case SerialPortEvent.BI:
                System.out.println("bi");
                break;
            case SerialPortEvent.CD:
                System.out.println("cd");
                break;
            case SerialPortEvent.CTS:
                System.out.println("cts");
                break;
            case SerialPortEvent.DATA_AVAILABLE:
                System.out.println("data");
                break;
            case SerialPortEvent.DSR:
                System.out.println("dsr");
                break;
            case SerialPortEvent.FE:
                System.out.println("fe");
                break;
            case SerialPortEvent.OE:
                System.out.println("oe");
                break;
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                System.out.println("output");
                break;
            case SerialPortEvent.PE:
                System.out.println("pe");
                break;
            case SerialPortEvent.RI:
                System.out.println("ri");
                break;
        }
    }
}
