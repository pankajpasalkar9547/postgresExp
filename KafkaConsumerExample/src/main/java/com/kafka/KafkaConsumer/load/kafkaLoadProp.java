package com.kafka.KafkaConsumer.load;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class kafkaLoadProp {

	public Properties getProperty() {
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("/KafkaConsumerExample/src/main/properties/"
					+ "kafka.properties"));
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
