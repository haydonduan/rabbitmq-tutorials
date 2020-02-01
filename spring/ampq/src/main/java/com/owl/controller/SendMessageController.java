package com.owl.controller;

import com.owl.exchange.type.direct.DirectConstants;
import com.owl.exchange.type.topic.TopicConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage(@RequestParam(value = "data", required = false) String data) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "Hello Owl");

        rabbitTemplate.convertAndSend(DirectConstants.DIRECT_EXCHANGE_NAME, "", map);
        return "ok";
    }

    @GetMapping("/sendTopicMessage")
    public String sendTopicMessage(@RequestParam(value = "data", required = false) String data, @RequestParam("routingKey") String routingKey) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "Hello Owl");

        rabbitTemplate.convertAndSend(TopicConstants.TOPIC_EXCHANGE_NAME, routingKey, map);
        return "ok";
    }


}
