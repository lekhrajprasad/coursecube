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

import java.math.BigInteger;
import java.util.List;

@SpringBootApplication
public class MyBootApp implements CommandLineRunner {
    static final Logger log = LoggerFactory.getLogger(MyBootApp.class);

    @Autowired
    CustomerDAO cdao;


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MyBootApp.class, args);
        ctx.close();
    }

    @Override
    public void run(String... args) {

        log.info("My Boot App - run() begin");
        log.info("-------------------------------------");
        // 1. addCustomer
        Customer cust1 = new Customer("sri", "sri@jlc", 12346, "Blore");
        cdao.addCustomer(cust1);

        // 2. updateCustomer
        Customer cust2 = new Customer("vas-update", "vas@jlc", 8888, "Blore");
        cust2.setCid(19);
        cdao.updateCustomer(cust2);

        // 3. deleteCustomer
        //cdao.deleteCustomer(8);

        // 4. getCustomerByCid
        Customer cust3 = cdao.getCustomerByCid(9);
        System.out.println(cust3);

        //6.getCustomersByCity
        List<Customer> list = cdao.getCustomersByCity("Gaya");
        list.forEach(System.out::println);

        //7.getCustomersByEmail
        list = cdao.getCustomersByEmail("sri@jlc");
        list.forEach(System.out::println);

        //8.getCustomersByEmailAndPhone
        list = cdao.getCustomersByEmailAndPhone("sri@jlc", 1234);
        list.forEach(System.out::println);

        //9.getCustomersByEmailOrPhone
        list = cdao.getCustomersByEmailOrPhone("sri@jlc", 123456890);
        list.forEach(System.out::println);

        //5.getAllCustomers
        log.info("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        List<Customer> list1 = cdao.getAllCustomers();
        list1.forEach(System.out::println);
        log.info("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");

        //10.getCustomerCount
        BigInteger big = cdao.getCustomerCount();
        System.out.println("All Count : " + big.intValue());

        //11.getCustomerCountByCity
        big = cdao.getCustomerCountByCity("Hyd");
        System.out.println("Count : " + big.intValue());

        //12.getCityByEmail
        String city = cdao.getCityByEmail("vas@jlc");
        System.out.println(city);

        //13.getPhoneByEmail
        long phone = cdao.getPhoneByEmail("vas@jlc");
        System.out.println(phone);

        //14.getCidByPhone
        int cid = cdao.getCidByPhone(12346);
        System.out.println(cid);


        log.info("-------------------------------------");
        log.info("My Boot App - run() END");
    }

}
