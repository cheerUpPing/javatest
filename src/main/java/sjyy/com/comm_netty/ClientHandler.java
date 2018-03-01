package sjyy.com.comm_netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import sjyy.com.LogUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Email cheerupping@163.com
 * Time  2017/5/13 16:51
 * <p>
 * 描述 通道事件驱动器
 */
public class ClientHandler extends SimpleChannelInboundHandler {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /**
     * 读取到信息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("i am client,received server " + channel + " information [" + msg + "]");
    }

    /**
     * 通道建立连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("i am client,had established channel to server " + channel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof IOException && !ctx.channel().isActive()) {
            Object channel = CommNettyTest.map.get("1");
            if (channel instanceof Channel){
                ((Channel)channel).close();
            }
            CommNettyTest.map.put("1", new Object());
            System.out.println("client needs to reconnect serial comm");
            //一直重连
            while (true) {
                TimeUnit.SECONDS.sleep(5);
                if (CommNettyTest.connectServer()) {
                    System.out.println("------------------reconnect success");
                    break;
                }
            }
        }
        System.out.println("client had occured exception: [" + LogUtil.getStackTrace(cause) + "]");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("======ddddfsfsfsdfdsfsfsfdsfsf===================");
    }

    /**
     * 每次超时时间触发，就向服务器发送心跳，服务器接收到心跳后就回复心跳，然后客户端根据收到的信息确实是否连接正常
     *
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        MsgWapper msgWapper = new MsgWapper();
        msgWapper.setFrom("system_heart");
        ctx.writeAndFlush(msgWapper);
        System.out.println(sdf.format(new Date()) + "===================trigger heart");
    }
}
