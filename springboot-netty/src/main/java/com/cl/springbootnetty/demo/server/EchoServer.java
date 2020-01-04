package com.cl.springbootnetty.demo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.channelFactory(new ChannelFactory<ServerChannel>() {
                @Override
                public ServerChannel newChannel() {
                    return new NioServerSocketChannel();
                }
            });

            bootstrap.group(group)
                    .localAddress(port)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.bind().sync();
            System.out.println(EchoServer.class.getName() + "started and listen on" +
                    channelFuture.channel().localAddress());
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(8080).start();
    }
}
