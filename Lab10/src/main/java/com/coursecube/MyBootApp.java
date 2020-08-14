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

import java.util.List;

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
		Customer cust1 = new Customer("lekhraj", "lekh@com", 123456890, "Gaya");
		customerDAO.addCustomer(cust1);

		/*List<Customer> list1 = customerDAO.getAllCustomers();
		list1.forEach(System.out::println);*/

		List<Customer> list2 = customerDAO.getCustomerByCity("Gaya");
		list2.forEach(System.out::println);

		/*customerDAO.deleteAllCustomersGrThenId(14);
		List<Customer> list1 = customerDAO.getAllCustomers();
		list1.forEach(System.out::println);*/

		log.info("-------------------------------------");
		log.info("My Boot App - run() END");
	}

}
