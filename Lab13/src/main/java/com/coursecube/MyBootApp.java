package com.coursecube;

import com.coursecube.springboot.Customer;
import com.coursecube.springboot.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyBootApp implements CommandLineRunner {
    static final Logger log = LoggerFactory.getLogger(MyBootApp.class);

    @Autowired
    CustomerService customerService;


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MyBootApp.class, args);
        ctx.close();
    }

    @Override
    public void run(String... args) {

        log.info("My Boot App - run() begin");
        log.info("-------------------------------------");

        Customer customer1 = customerService.getCustomerById(380);
        System.out.println(customer1);

        Customer customer2 = customerService.getCustomerOne(41);
        System.out.println(customer2);

        log.info("-------------------------------------");
        log.info("My Boot App - run() END");
    }

}
