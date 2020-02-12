package com.owl.exchange.type.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue directQueue() {
        return new Queue(DirectConstants.DIRECT_QUEUE_NAME, true);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DirectConstants.DIRECT_EXCHANGE_NAME);
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("cici");
    }

}
