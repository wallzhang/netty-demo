package com.wall.nettydemo.code.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class NettyByteBufExample {
    public static void main(String[] args) {
        ByteBuf buf= ByteBufAllocator.DEFAULT.buffer();
        System.out.println(buf);
    }
}
