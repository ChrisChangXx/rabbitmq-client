package com.chris;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ连接工具类
 *
 * @author zhangh
 * @date 2021/01/11
 */
public class RabbitConnectionUtil {

    /**
     * 获得连接
     *
     * @return {@link Connection}
     * @throws IOException      IO异常
     * @throws TimeoutException 超时异常
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置服务地址
        connectionFactory.setHost("127.0.0.7");
        //端口
        connectionFactory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        //设置虚拟机，一个mq服务可以设置多个虚拟机，每个虚拟机就相当于一个独立的mq
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        // 通过工厂获取连接
        return connectionFactory.newConnection();
    }
}
