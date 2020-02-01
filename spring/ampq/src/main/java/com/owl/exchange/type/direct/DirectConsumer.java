package com.owl.exchange.type.direct;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = Constants.DIRECT_QUEUE_NAME)
public class DirectConsumer {

    @RabbitHandler
    public void process(Map message) {
        System.out.println("DirectConsumer: " + message.toString());
    }
}
