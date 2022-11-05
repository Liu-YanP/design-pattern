package com.lyp.netty.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 处理服务端channel
 *
 * @author Liu Yanping
 * @date 2021/7/4 22:29
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = ((ByteBuf) msg);

            if (in.isReadable()) {
                System.out.print((char) in.readByte());
                System.out.flush();
            }
    }

    /**
     * 捕捉io错误以及其他异常事件
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
