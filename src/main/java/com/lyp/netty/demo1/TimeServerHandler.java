package com.lyp.netty.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author Liu Yanping
 * @date 2021/7/4 23:39
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 当连接建立，准备生产流量时调用
     *
     * @param ctx
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        final ByteBuf time = ctx.alloc().buffer(4); // 初始化缓存区
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(time); // 返回事件，但并不是立即完成
        f.addListener(new ChannelFutureListener() {  // 监听 channelFuture完成时的事件
            @Override
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        }); // (4)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
