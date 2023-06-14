package com.schalldach.mathengine;

import com.schalldach.mathengine.data.CalculationRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MathEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathEngineApplication.class, args);
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		final Map<String, Class<?>> typeIDs = new HashMap<>();
		typeIDs.put("com.schalldach.data.Calculation", CalculationRequest.class);

		converter.setTypeIdMappings(typeIDs);

		return converter;
	}
}
