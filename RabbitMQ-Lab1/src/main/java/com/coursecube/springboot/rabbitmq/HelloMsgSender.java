package com.coursecube.springboot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloMsgSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendHelloMsg(String msg){
        String  routingKey = JLCBeanConfig.HELLO_QUEUE;
        rabbitTemplate.convertAndSend(routingKey, msg);
    }


}
