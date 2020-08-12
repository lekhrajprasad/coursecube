package com.coursecube.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBootApp implements CommandLineRunner {
	static final Logger LOG = LoggerFactory.getLogger(MyBootApp.class);

	@Autowired
	CustomerDAO cdao;

	public static void main(String[] args) {
		LOG.info("My Boot App - Main() begin");
		LOG.debug("My Boot App - Main() begin");
		SpringApplication.run(MyBootApp.class, args);
		LOG.info("My Boot App - Main() end ");
		LOG.debug("My Boot App - Main() end");
	}

	@Override
	public void run(String... args) {
		LOG.info("MyBootApp..run() method ----Starts");
		LOG.info("------------------------------------");
		// 1. addCustomer
		Customer cust1 = new Customer(24, "sd2", "sd1@jlc", 1111, "Pune");
		cdao.addCustomer(cust1);
		// 2. getAllCustomers
		LOG.info("getAllCustomers");
		List<Customer> list = cdao.getAllCustomers();
		list.forEach(cust -> System.out.println(cust));

		List<Customer> list2=cdao.getCustomersByCity("Pune");
		list2.forEach(cust -> System.out.println(cust));

		LOG.info("------------------------------------");
		LOG.info("MyBootApp..run() method ----- Ends");
	}
}
