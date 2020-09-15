package com.coursecube.springboot.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JLCBeanConfig {
	public static final String TOPIC_EXCHANGE= "topic-exchange-test";
	//public static final String HELLO_QUEUE= "hello-queue";

	/*public static final String ORDER_EXCHANGE= "order-exchange";
	public static final String ORDER_QUEUE= "order-queue";

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
	}*/


	@Bean(name="topicExchangeTest")
	Exchange createTopicExchangeTest() {
		return ExchangeBuilder.topicExchange("topic-exchange-test").build();
	}

	@Bean(name="queue1")
	Queue createQueue1() {
		return QueueBuilder.durable("queue-1").build();
	}

	@Bean(name="queue2")
	Queue createQueue2() {
		return QueueBuilder.durable("queue-2").build();
	}

	@Bean(name="queue3")
	Queue createQueue3() {
		return QueueBuilder.durable("queue-3").build();
	}

	@Bean(name="queue4")
	Queue createQueue4() {
		return QueueBuilder.durable("queue-4").build();
	}

	@Bean(name="queue5")
	Queue createQueue5() {
		return QueueBuilder.durable("queue-5").build();
	}

	@Bean
	Binding binding1(@Qualifier("queue1") Queue queue, @Qualifier("topicExchangeTest") TopicExchange exchange) {
		return BindingBuilder.bind(queue)
				.to(exchange)
				.with("routKey-1");
	}
	@Bean
	Binding binding2(@Qualifier("queue2") Queue queue, @Qualifier("topicExchangeTest") TopicExchange exchange) {
		return BindingBuilder.bind(queue)
				.to(exchange)
				.with("routKey-2");
	}
	@Bean
	Binding binding3(@Qualifier("queue3") Queue queue, @Qualifier("topicExchangeTest") TopicExchange exchange) {
		return BindingBuilder.bind(queue)
				.to(exchange)
				.with("routKey-3");
	}
	@Bean
	Binding binding4(@Qualifier("queue4") Queue queue, @Qualifier("topicExchangeTest") TopicExchange exchange) {
		return BindingBuilder.bind(queue)
				.to(exchange)
				.with("routKey-4");
	}
	@Bean
	Binding binding5(@Qualifier("queue5") Queue queue, @Qualifier("topicExchangeTest") TopicExchange exchange) {
		return BindingBuilder.bind(queue)
				.to(exchange)
				.with("routKey-5");
	}

}
