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

        //2. save()
        Random random = new Random();
        int randomNum = random.nextInt(10000);
        final String name = "name-"+randomNum;
        Customer customer = new Customer(name, "email", 12345, "city", 20.05);
        customerDAO.save(customer);
        Customer customer1 = new Customer("name", "email", 12345, "city", 20.05);
        customerDAO.save(customer1);

        //1. DSL get/find/read are same => verb+subject(Optional)+word+predicate => get/find/read+Customer+By+Cname
        //List<Customer> list = customerDAO.getCustomersByCname("name");
        //List<Customer> list = customerDAO.readCustomersByCname("name");
        List<Customer> list = customerDAO.findCustomersByCname("name");
        //list.forEach(System.out::println);
        /*list = customerDAO.getByCname("name");
        list.forEach(System.out::println);*/

        //2. getByCnameAndEmail
        /*list = customerDAO.getByCnameAndEmail("name2", "email2");
        list.forEach(System.out::println);*/

        //3.
        list = customerDAO.getCustomerByEmailOrPhone("email11", 1234);
        //list.forEach(System.out::println);

        //4. getCustomer by cname like xx% predicate - LIKE
        list = customerDAO.getCustomersByCnameLike("name-%");
        //list.forEach(System.out::println);

        //5. predicate - IN
        list = customerDAO.getCustomersByCityIn("city2", "city1");
        //list.forEach(System.out::println);

        //6. predicate - NOTIN
        list = customerDAO.getCustomersByCityNotIn("Bang", "city");
        list.forEach(System.out::println);

        //7. verb - count
        long count = customerDAO.countCustomersByCityIn("city2", "city1", "pune");
        System.out.println(count);

        //8. predicate - Null
        long count1 = customerDAO.countCustomersByBalNull();
        System.out.println(count1);

        //9.
        list = customerDAO.getCustomersByBalGreaterThanEqual(0);
        //list.forEach(System.out::println);

        Sort sort = Sort.by(Sort.Direction.DESC, "bal");
        list = customerDAO.findAllByOrderByCity(sort);
        //list.forEach(System.out::println);

        list = customerDAO.findByCityOrderByCidDesc("pune");
        list.forEach(System.out::println);

        //10. Sort
        list = customerDAO.findByCityAndBalBetweenOrderByCidDesc("city", 0, 100);
        list.forEach(System.out::println);

        log.info("-------------------------------------");
        log.info("My Boot App - run() END");
    }

}
