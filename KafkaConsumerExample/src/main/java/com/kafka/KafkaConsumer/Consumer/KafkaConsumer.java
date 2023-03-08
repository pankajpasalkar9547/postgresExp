package com.kafka.KafkaConsumer.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.KafkaConsumer.load.kafkaLoadProp;

@Service
public class KafkaConsumer {
	
	@Autowired
	kafkaLoadProp loadProp;
	
	@KafkaListener(topics = "com.bt.tel",groupId = "default-spring-consumer")
	public void consume (String msg)
	{
		System.out.println("Message = "+msg );
		//System.out.println(loadProp.getProperty("kafkaTopic"));
	}

}
