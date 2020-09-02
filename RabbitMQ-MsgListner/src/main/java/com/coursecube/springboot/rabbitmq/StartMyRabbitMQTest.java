package com.coursecube.springboot.rabbitmq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartMyRabbitMQTest implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StartMyRabbitMQTest.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("RabbitMQTest Application Launched");

        System.out.println("Done!!!!!!");
    }
}
