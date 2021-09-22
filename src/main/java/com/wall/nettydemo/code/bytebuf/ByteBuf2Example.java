package com.wall.nettydemo.code.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.StringUtil;

public class ByteBuf2Example {
    public static void main(String[] args) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.heapBuffer();
        byteBuf.writeBytes(new byte[]{1,2,3,4});
        log(byteBuf);
        byteBuf.writeInt(5);
        log(byteBuf);
    }

    private static void log(ByteBuf buf){
        System.out.println(buf);
        StringBuilder builder = new StringBuilder()
                .append("read index:").append(buf.readerIndex())
                .append("write index").append(buf.writerIndex())
                .append("capacity:").append(buf.capacity())
                .append(StringUtil.NEWLINE);
        ByteBufUtil.appendPrettyHexDump(builder,buf);
        System.out.println(builder.toString());
    }
}
