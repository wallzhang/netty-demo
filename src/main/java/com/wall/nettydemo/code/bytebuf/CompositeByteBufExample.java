package com.wall.nettydemo.code.bytebuf;

import io.netty.buffer.*;
import io.netty.util.internal.StringUtil;

public class CompositeByteBufExample {
    public static void main(String[] args) {
        ByteBuf header = ByteBufAllocator.DEFAULT.buffer();
        header.writeBytes(new byte[]{1,2,3,4,5});
        ByteBuf body = ByteBufAllocator.DEFAULT.buffer();
        body.writeBytes(new byte[]{6,7,8,9,10});
//        ByteBuf total = Unpooled.buffer(header.readableBytes() + body.readableBytes() );
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        compositeByteBuf.addComponents(true,header,body);
    }


    private static void log(ByteBuf buf){
        StringBuilder sb = new StringBuilder()
                .append("read index:").append(buf.readerIndex())
                .append("write index:").append(buf.writerIndex())
                .append("capacity:").append(buf.capacity())
                .append(StringUtil.NEWLINE);
        ByteBufUtil.appendPrettyHexDump(sb,buf);
        System.out.println(sb.toString());
    }
}
