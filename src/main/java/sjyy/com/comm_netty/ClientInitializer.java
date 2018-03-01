package sjyy.com.comm_netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * Email cheerupping@163.com
 * Time  2017/5/13 16:43
 * <p>
 * 描述
 */
public class ClientInitializer extends ChannelInitializer {

    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        channelPipeline.addLast("string-decoder", new StringDecoder());
        channelPipeline.addLast("string-encoder", new StringEncoder());
        //心跳机制
        //channelPipeline.addLast("idle", new IdleStateHandler(0, 0, 6, TimeUnit.SECONDS));
        // 自己的逻辑Handler
        channelPipeline.addLast("handler", new ClientHandler());
    }
}
