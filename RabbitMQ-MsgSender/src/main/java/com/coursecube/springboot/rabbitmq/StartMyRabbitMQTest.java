package com.coursecube.springboot.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StartMyRabbitMQTest implements CommandLineRunner {
    @Autowired
    HelloMsgSender helloMsgSender;

    @Autowired
    OrderSender orderSender;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(StartMyRabbitMQTest.class, args);
        ctx.close();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("RabbitMQTest Application Launched");
        helloMsgSender.sendHelloMsg("Hello Guys, How are you doing ?");

        /*for(int i=0; i<Integer.MAX_VALUE; i++){
            Order order = new Order(i, "31-Aug-2020", 99+i, 5,2500 , true);
            orderSender.sendOrder(order);
        }*/
        System.out.println("Done!!!!!!");
    }
}
