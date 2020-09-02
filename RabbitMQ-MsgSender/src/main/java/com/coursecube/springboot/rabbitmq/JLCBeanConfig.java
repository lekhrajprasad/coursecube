package com.coursecube.springboot.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JLCBeanConfig {
	public static final String HELLO_EXCHANGE= "hello-exchange";
	public static final String HELLO_QUEUE= "hello-queue";

	public static final String ORDER_EXCHANGE= "order-exchange";
	public static final String ORDER_QUEUE= "order-queue";

	@Bean(name="helloExchange")
	Exchange createHelloExchange() {
		return ExchangeBuilder.topicExchange(HELLO_EXCHANGE).build();
	}

	@Bean(name="helloQueue")
	Queue createHelloQueue() {
		return QueueBuilder.durable(HELLO_QUEUE).build();
	}

	@Bean
	Binding helloMsgBinding(Queue helloQueue, TopicExchange helloExchange) {
		return BindingBuilder.bind(helloQueue)
				.to(helloExchange)
				.with(HELLO_QUEUE);
	}

	@Bean(name="orderExchange")
	Exchange createOrderExchange() {
		return ExchangeBuilder.topicExchange(ORDER_EXCHANGE).build();
	}
	@Bean(name="orderQueue")
	Queue createOrderQueue() {
		return QueueBuilder.durable(ORDER_QUEUE).build();
	}

	@Bean
	Binding orderBinding(Queue orderQueue, TopicExchange orderExchange) {
		return BindingBuilder.bind(orderQueue)
				.to(orderExchange)
				.with(ORDER_QUEUE); //R.K
	}
}
