package com.resteasy.netty;

import com.resteasy.netty.server.NettyServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huangsy
 * @date 2018/4/18 17:49
 */
public class RestNettyServer {

    public static void main(String[] args)
            throws Exception {

        ApplicationContext ac = new ClassPathXmlApplicationContext("root-context.xml");

        NettyServer netty = ac.getBean(NettyServer.class);

        netty.start();

    }

}
