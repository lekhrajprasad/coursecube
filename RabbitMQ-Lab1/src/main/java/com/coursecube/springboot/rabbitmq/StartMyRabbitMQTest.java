package com.coursecube.springboot.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartMyRabbitMQTest implements CommandLineRunner {
    @Autowired
    HelloMsgSender helloMsgSender;

    @Autowired
    OrderSender orderSender;

    public static void main(String[] args) {
        SpringApplication.run(StartMyRabbitMQTest.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("RabbitMQTest Application Launched");
        helloMsgSender.sendHelloMsg("Hello Guys, How are you doing ?");

        Order order = new Order(101, "31-Aug-2020", 99, 5,2500 , true);
        orderSender.sendOrder(order);
        orderSender.sendOrder(order);
        orderSender.sendOrder(order);
        orderSender.sendOrder(order);
        System.out.println("Done!!!!!!");
    }
}
