package com.example.mscourse.Config;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;

public class RabbitConfig {
    public static final String QUEUE_NAME = "course.queue";
    public static final String EXCHANGE_NAME = "course.exchange";
    public static final String ROUTING_KEY = "course.routing";

    @Bean
    public Queue courseQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange courseExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding courseBinding() {
        return BindingBuilder
                .bind(courseQueue())
                .to(courseExchange())
                .with(ROUTING_KEY);
    }
}
