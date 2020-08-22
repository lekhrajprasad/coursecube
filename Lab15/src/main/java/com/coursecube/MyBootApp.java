package com.coursecube;

import com.coursecube.springboot.Customer;
import com.coursecube.springboot.CustomerDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class MyBootApp implements CommandLineRunner {
    static final Logger log = LoggerFactory.getLogger(MyBootApp.class);

    @Autowired
    CustomerDAO customerDAO;


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MyBootApp.class, args);
        ctx.close();
    }

    @Override
    public void run(String... args) {

        log.info("My Boot App - run() begin");
        log.info("-------------------------------------");

        List<Customer> list = customerDAO.getCustomers1("email", 12345);
        //list.forEach(System.out::println);

        //2. Order
        Sort sort = Sort.by(Sort.Direction.DESC, "cid");
        list = customerDAO.getCustomers4("city", sort);
        //list.forEach(System.out::println);

        //3. Pagination
        Pageable pageable = PageRequest.of(1, 5);
        list = customerDAO.getCustomers5("city", pageable);
        //list.forEach(System.out::println);

        //4. Native Queries
        list = customerDAO.findCustomersByCity("city");
        //list.forEach(System.out::println);

        //5. Native Queries with Param
        list = customerDAO.findCustomersByPhone(12345);
        list.forEach(System.out::println);

        log.info("-------------------------------------");
        log.info("My Boot App - run() END");
    }

}
