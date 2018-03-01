package serial_com;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

/**
 * 2017/9/21 14:48.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 串口监听器
 */
public class SerialListener implements SerialPortEventListener {
    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        switch (serialPortEvent.getEventType()) {

            case SerialPortEvent.BI: // 10 通讯中断
                System.out.println("disconnect.......");
                break;

            case SerialPortEvent.OE: // 7 溢位（溢出）错误

            case SerialPortEvent.FE: // 9 帧错误

            case SerialPortEvent.PE: // 8 奇偶校验错误

            case SerialPortEvent.CD: // 6 载波检测

            case SerialPortEvent.CTS: // 3 清除待发送数据

            case SerialPortEvent.DSR: // 4 待发送数据准备好了

            case SerialPortEvent.RI: // 5 振铃指示

            case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2 输出缓冲区已清空
                System.out.println("输出缓冲区已清空");
                break;

            case SerialPortEvent.DATA_AVAILABLE: // 1 串口存在可用数据

                System.out.println("wrong....");
                System.exit(0);    //发生读取错误时显示错误信息后退出系统

                break;

        }
    }
}
