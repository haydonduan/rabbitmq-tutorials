package com.owl.exchange.type.topic;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = TopicConstants.TOPIC_QUEUE_NAME)
public class TopicConsumer {

    @RabbitHandler
    public void process(Map message) {
        System.out.println("TopicConsumer: " + message.toString());
    }
}
