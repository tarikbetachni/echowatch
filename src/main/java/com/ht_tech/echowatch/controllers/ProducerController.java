package com.ht_tech.echowatch.controllers;

import com.ht_tech.echowatch.kafka.consumers.KafkaConsumer;
import com.ht_tech.echowatch.kafka.producers.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @PostMapping("/write")
    public void produce(@RequestBody Map<String,String> request) {
        String message = request.get("message");
        kafkaProducer.sendMessage(message);

    }
}
