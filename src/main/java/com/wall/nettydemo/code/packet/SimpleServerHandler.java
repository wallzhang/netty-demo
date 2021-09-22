package com.wall.nettydemo.code.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.UUID;

public class SimpleServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes);
        String body = new String(bytes,"UTF-8");
        System.out.println("服务端收到消息:" + body);
        ByteBuf resp = Unpooled.copiedBuffer(UUID.randomUUID().toString().getBytes());
        ctx.writeAndFlush(resp);
    }
}
