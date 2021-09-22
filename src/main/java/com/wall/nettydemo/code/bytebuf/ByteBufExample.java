package com.wall.nettydemo.code.bytebuf;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.StringUtil;

/**
* @Description: ByteBuf自助
* @Author: zhang.zw
* @Date: 2021/9/21 
*/
public class ByteBufExample {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        log(buffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append("-" + i);
        }
        buffer.writeBytes(sb.toString().getBytes());
        log(buffer);
    }

    private static void log(ByteBuf buf){
        StringBuilder sb = new StringBuilder()
                .append("read index:").append(buf.readerIndex())
                .append("============")
                .append("write index:").append(buf.writerIndex())
                .append("============")
                .append("capacity:").append(buf.capacity())
                .append(StringUtil.NEWLINE);
        ByteBufUtil.appendPrettyHexDump(sb,buf);
        System.out.println(sb.toString());
    }
}
