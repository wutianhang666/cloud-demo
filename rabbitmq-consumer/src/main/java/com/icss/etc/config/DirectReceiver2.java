package com.icss.etc.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 两个监听者监听一个队列 轮询消费
 */

@Component
//监听的队列名称 TestDirectQueue
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver2 {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver2消费者收到消息  : " + testMessage.toString());
    }

}
