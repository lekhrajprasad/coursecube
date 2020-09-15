package com.coursecube.springboot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StartMyRabbitMQTest implements CommandLineRunner {
    /*@Autowired
    HelloSender helloMsgSender;

    @Autowired
    OrderSender orderSender;*/
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(StartMyRabbitMQTest.class, args);
        ctx.close();
    }

    @Override
    public void run(String... args) throws Exception {
        
        rabbitTemplate.convertAndSend("topic-exchange-test", "routKey-1", "Welcome!!");
        /*rabbitTemplate.convertAndSend("routKey-1", "Welcome!!");
        rabbitTemplate.convertAndSend("routKey-2", "Welcome!!");
        rabbitTemplate.convertAndSend("routKey-2", "Welcome!!");
        rabbitTemplate.convertAndSend("routKey-3", "Welcome!!");
        rabbitTemplate.convertAndSend("routKey-3", "Welcome!!");
        rabbitTemplate.convertAndSend("routKey-4", "Welcome!!");
        rabbitTemplate.convertAndSend("routKey-4", "Welcome!!");
        rabbitTemplate.convertAndSend("routKey-5", "Welcome!!");
        rabbitTemplate.convertAndSend("routKey-5", "Welcome!!");*/
        
        //for(int i=0; i<Integer.MAX_VALUE; i++){
            //Order order = new Order(i, "31-Aug-2020", 99+i, 5,2500 , true);
        //Order order = new Order(1, "31-Aug-2020", 99+1, 5,2500 , true);
          //  orderSender.sendOrder(order);
       // }
        System.out.println("Done!!!!!!");

        System.out.println("RabbitMQTest Application Launched");
        //helloMsgSender.sendHelloMsg("Hello Guys, How are you doing ?");
    }
}
