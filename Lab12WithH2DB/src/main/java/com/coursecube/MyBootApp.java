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
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
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
        //1. delete all to clean the table
        //customerDAO.deleteAll();

        //2. save()
        Random random = new Random();
        int randomNum = random.nextInt(10000);
        final String name = "name-"+randomNum;
        Customer customer = new Customer(name, "email", 12345, "city");
        customerDAO.save(customer);

        //3. saveAll()
        Customer customer1 = new Customer("name11", "email11", 11111, "city11");
        Customer customer2 = new Customer("name22", "email22", 22222, "city22");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerDAO.saveAll(customerList);

        //4. findAll
        log.info("zzzzzzzzzzzzzzz--findAll--zzzzzzzzzzzzzzzzzz");
        List<Customer> list = customerDAO.findAll();
        list.forEach(System.out::println);
        log.info("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");

        // 9. count()
        long count = customerDAO.count();
        System.out.println("No of record in table: "+count);

        log.info("-------------------------------------");
        log.info("My Boot App - run() END");
    }

}
