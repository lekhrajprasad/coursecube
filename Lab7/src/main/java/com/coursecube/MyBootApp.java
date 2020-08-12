package com.coursecube;

import com.coursecube.dao.HelloDAO;
import com.coursecube.service.HelloService;
import com.coursecube.springboot.Hai;
import com.coursecube.springboot.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

@SpringBootApplication
public class MyBootApp implements CommandLineRunner {

	@Autowired
	Hello hello;

	@Autowired
	Hai hai;

	@Autowired
	HelloService helloService;

	@Autowired
	HelloDAO helloDAO;

	@Autowired
	DataSource myds;

	public static void main(String[] args) {
		System.out.println("MyBootApp - Main begin");
		SpringApplication.run(MyBootApp.class, args);
		System.out.println("MyBootApp - Main end");
	}

	@Override
	public void run(String... args) throws Exception{
		//Do Your Start-Up Task Here
		System.out.println("I am run() CLR - doing Start-Up Task");
		System.out.println("CLR - run() - Begin");

		hello.show();
		hai.show();
		helloService.show();
		helloDAO.show();

		Connection con = myds.getConnection();
		DatabaseMetaData databaseMetaData = con.getMetaData();
		System.out.println(databaseMetaData.getDatabaseProductName());

		System.out.println("CLR - run() - End");


	}

	@Bean
	public Hello getHello() {
		return new Hello();
	}
}
