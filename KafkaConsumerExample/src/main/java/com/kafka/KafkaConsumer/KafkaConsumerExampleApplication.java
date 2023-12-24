package com.kafka.KafkaConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerExampleApplication {

	public static void main(String[] args) {
		System.out.println("Added comment in Main file");
		SpringApplication.run(KafkaConsumerExampleApplication.class, args);
	}

}
