package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableScheduling
public class ProducerAppApplication implements CommandLineRunner {
    @Autowired
    private KafkaKeyProducer kafkaKeyProducer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerAppApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* System.out.println("test");
        helloKafkaProducer.sendHello("Timeouts "+ ThreadLocalRandom.current().nextInt());*/
        for (int i = 0; i < 30; i++){
            var key = "key-"+(i%4);
            var value = "value "+ i + "with key"+ key;
            kafkaKeyProducer.send(key,value);
        }
    }
}