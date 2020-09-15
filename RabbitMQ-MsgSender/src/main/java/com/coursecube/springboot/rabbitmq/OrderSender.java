/*
package com.coursecube.springboot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order order){
        String routingKey = JLCBeanConfig.ORDER_QUEUE;
        rabbitTemplate.convertAndSend(routingKey, order);
    }
}
*/
