package com.kafka.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class HelloKafkaConsumer {

    @Value("${spring.kafka.consumer.groupId}")
    private String groupId;





    @KafkaListener(topics = "t-hello", groupId = "groupid")
    public void handleMessage(@Payload String message){
        System.out.println(message);
    }
}
