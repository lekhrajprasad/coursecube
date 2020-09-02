package com.coursecube.springboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {
    @RabbitListener(queues = JLCBeanConfig.ORDER_QUEUE)
    public void placeOrder(Order order){
        System.out.println("Order Received: "+order);
    }
}
