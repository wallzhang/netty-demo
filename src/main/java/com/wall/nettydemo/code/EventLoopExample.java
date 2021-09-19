package com.wall.nettydemo.code;

import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;

public class EventLoopExample {

    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup(2);
        // 把channel注册到某个EventLoop的Selector
        NioEventLoop nioEventLoop = (NioEventLoop) group.next();
//        group.register();
        System.out.println(group.next());
        System.out.println(group.next());

        group.next().submit(()->{
            System.out.println(Thread.currentThread().getName() + "--------");
        });
        group.next().submit(()->{
            System.out.println(Thread.currentThread().getName() + "--------");
        });
    }
}
