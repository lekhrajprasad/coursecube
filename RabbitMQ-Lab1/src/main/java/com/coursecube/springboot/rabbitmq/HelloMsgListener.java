package com.coursecube.springboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloMsgListener {
    @RabbitListener(queues = JLCBeanConfig.HELLO_QUEUE)
    public void processHelloMsg(String msg){
        System.out.println("HelloMsgListener - processHelloMsg()");
        System.out.println("------------------------------------");
        System.out.println("Hello Message Received: " + msg);
        System.out.println("------------------------------------");
    }
}
