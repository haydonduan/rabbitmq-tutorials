package com.owl.exchange.type.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue topicQueue() {
        return new Queue(TopicConstants.TOPIC_QUEUE_NAME, true);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TopicConstants.TOPIC_EXCHANGE_NAME);
    }

    @Bean
    Binding bindingTopic() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("owl.*");
    }

}
