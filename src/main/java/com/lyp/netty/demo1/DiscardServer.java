package com.lyp.netty.demo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 丢弃任何接收到的数据
 *
 * @author Liu Yanping
 * @date 2021/7/4 22:48
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        // NioEventLoopGroup 是一个处理 I/O 操作的多线程事件循环
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // 处理connection信息
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //处理connection的流量
        try {
            // 设置服务器的辅助类，也可以直接通过channel直接设置
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // 使用 NioServerSocketChannel 类实例化一个新的 Channel 以接受传入的连接
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 初始化channel，并指定处理类例如DiscardServerHandler
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    //.addLast(new TimeServerHandler())   //可以向管道里添加多个处理类
                                  //  .addLast(new DiscardServerHandler())
                                    .addLast(new EchoServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // channel的配置参数  例如 keepAlive
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // 绑定并开始接受进入的连接
            ChannelFuture f = b.bind(port).sync(); // (7)
            System.out.println("服务其准备就绪");

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new DiscardServer(port).run();
    }
}
