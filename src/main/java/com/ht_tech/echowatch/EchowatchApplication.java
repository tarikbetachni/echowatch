package com.ht_tech.echowatch;

import com.ht_tech.echowatch.kafka.producers.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EchowatchApplication implements CommandLineRunner {

	@Autowired
	private KafkaProducer kafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(EchowatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaProducer.sendMessage("Hello from Kafka!");
	}
}
