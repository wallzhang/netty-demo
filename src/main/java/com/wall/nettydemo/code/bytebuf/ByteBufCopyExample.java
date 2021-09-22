package com.wall.nettydemo.code.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.StringUtil;

/**
 * @description:零拷贝
 * @author: zhang.zw
 * @date: 2021/9/22 21:24
 **/
public class ByteBufCopyExample {
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        buf.writeBytes(new byte[]{1,2,3,4,5,6,7,8,9,10});
        log(buf);
        ByteBuf bb1 = buf.slice(0,5);
        ByteBuf bb2 = buf.slice(5,5);
        log(bb1);
        log(bb2);
        System.out.println("修改原始数据");
        buf.setByte(2,8);
        log(bb1);
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
