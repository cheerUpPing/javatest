package sjyy.com.comm_netty;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.rxtx.RxtxChannel;
import io.netty.channel.rxtx.RxtxChannelConfig;
import io.netty.channel.rxtx.RxtxChannelOption;
import io.netty.channel.rxtx.RxtxDeviceAddress;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.log4j.Logger;
import sjyy.com.LogUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 2017/9/12 9:17.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class CommNettyTest {

    private static Logger logger = Logger.getLogger(CommNettyTest.class);

    private static String driveClassName = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@192.168.16.5:1521:ORCL";
    private static String user = "jidi1";
    private static String password = "jidi1";

    public static Map<String, Object> map = new ConcurrentHashMap<>();
    public static int count = 1;

    public static String com = "COM12";

    public static boolean connectServer() {
        EventLoopGroup eventLoopGroup = new OioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup);
        bootstrap.option(RxtxChannelOption.BAUD_RATE, 9600);
        bootstrap.option(RxtxChannelOption.STOP_BITS, RxtxChannelConfig.Stopbits.STOPBITS_1);
        bootstrap.option(RxtxChannelOption.RTS, true);
        bootstrap.option(RxtxChannelOption.DTR, false);
        bootstrap.option(RxtxChannelOption.DATA_BITS, RxtxChannelConfig.Databits.DATABITS_8);
        bootstrap.option(RxtxChannelOption.PARITY_BIT, RxtxChannelConfig.Paritybit.NONE);
        bootstrap.channel(RxtxChannel.class);
        bootstrap.handler(new ClientInitializer());
        Object channel = null;
        try {
            RxtxDeviceAddress rxtxDeviceAddress = new RxtxDeviceAddress(com);
            //和串口通信的通道
            if (map.get("1") != null && map.get("1") instanceof Channel) {
                channel = map.get("1");
            } else {
                if (isExist(com)) {
                    ChannelFuture future = bootstrap.connect(rxtxDeviceAddress);
                    future = future.sync();
                    channel = future.channel();
                    map.put("1", channel);
                }
            }
            if (channel != null && channel instanceof Channel) {
                //TimeUnit.SECONDS.sleep(10);
                byte[] bytes = {(byte) 0xcb, 0x09, (byte) 0xcb};
                for (byte b : bytes){
                    ((Channel) channel).writeAndFlush(b);
                    TimeUnit.MILLISECONDS.sleep(2);
                }
                ((Channel) channel).flush();
                System.out.println("发送成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //eventLoopGroup.shutdownGracefully();
            return channel != null;
        }
    }

    /**
     * 检测串口是否存在
     *
     * @param comm
     * @return
     */
    public static boolean isExist(String comm) {
        boolean isExist = true;
        CommPortIdentifier commPortIdentifier = null;
        try {
            commPortIdentifier = CommPortIdentifier.getPortIdentifier(comm);
            if (commPortIdentifier == null) {
                isExist = false;
            }
        } catch (NoSuchPortException e) {
            isExist = false;
            logger.info("串口【" + comm + "】不存在," + LogUtil.getStackTrace(e));
        }
        return isExist;
    }

    public static TicketInfo select(String sql) throws SQLException {
        Connection connection = Connect();
        QueryRunner queryRunner = new QueryRunner();
        return queryRunner.query(connection, sql, new BeanHandler<TicketInfo>(TicketInfo.class));
    }


    public static Connection Connect() {
        Connection conn = null;
        try {
            Class.forName(driveClassName);
        } catch (ClassNotFoundException e) {
            System.out.println(LogUtil.getStackTrace(e));
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(LogUtil.getStackTrace(e));
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        connectServer();
    }
}
