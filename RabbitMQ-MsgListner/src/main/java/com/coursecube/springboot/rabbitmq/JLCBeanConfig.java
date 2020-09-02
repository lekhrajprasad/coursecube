package com.coursecube.springboot.rabbitmq;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JLCBeanConfig {
	public static final String HELLO_EXCHANGE= "hello-exchange";
	public static final String HELLO_QUEUE= "hello-queue";

	public static final String ORDER_EXCHANGE= "order-exchange";
	public static final String ORDER_QUEUE= "order-queue";

}
