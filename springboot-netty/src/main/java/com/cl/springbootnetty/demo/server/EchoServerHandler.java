package com.cl.springbootnetty.demo.server;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.ConcurrentHashMap;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    public static final ConcurrentHashMap<String, ChannelHandlerContext> session = new ConcurrentHashMap<>();

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // ByteBuf buf = (ByteBuf) msg;
        // String s = ByteBufUtil.hexDump(buf.readBytes(buf.readableBytes()));
        System.err.println("Server received: " + msg);
        Channel channel = ctx.channel();
        session.put(ctx.channel().id().asLongText(), ctx);
        String s = JSONObject.toJSONString(channel);
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
                // .addListener(ChannelFutureListener.CLOSE);
    }


    public static void main(String[] args) {
        ConcurrentHashMap.KeySetView<String, ChannelHandlerContext> strings = session.keySet();
        strings.forEach(s -> {
            ChannelHandlerContext context = session.get(s);
        });
    }
}
