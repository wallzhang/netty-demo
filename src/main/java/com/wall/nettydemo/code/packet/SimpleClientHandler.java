package com.wall.nettydemo.code.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class SimpleClientHandler extends ChannelInboundHandlerAdapter {

    private int count;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接成功");
        for (int i = 0; i < 10; i++) {
            ByteBuf buf = Unpooled.copiedBuffer("客户端消息"+i, Charset.forName("utf-8"));
            ctx.writeAndFlush(buf);
        }
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes);
        String body = new String(bytes,"UTF-8");
        System.out.println("服务端收到消息:" + body);
        System.out.println("服务端收到消息数量:" + (++count));
//        ByteBuf resp = Unpooled.copiedBuffer(("服务端收到消息:" + body).getBytes());
//        ctx.writeAndFlush(resp);
        super.channelRead(ctx,msg);
    }
}
