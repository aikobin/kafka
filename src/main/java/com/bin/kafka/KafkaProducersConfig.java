﻿package com.bin.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * producer生产者配置
 *
 * @author bin
 * @version 1.0 2018年4月4日 下午3:24:32
 */
@Configuration
@EnableKafka
public class KafkaProducersConfig {
	 @Value("${kafka-config.kafka.binder.brokers}")
	    private String brokers;
	 	
	 	
	    @Bean("kafkaTemplate")
	    public KafkaTemplate<String, String> kafkaTemplate() {
	        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<String, String>(producerFactory());
	        return kafkaTemplate;
	    }

	    public ProducerFactory<String, String> producerFactory() {

	        // set the producer properties
	        Map<String, Object> properties = new HashMap<String, Object>();
	        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
	        
	        properties.put(ProducerConfig.RETRIES_CONFIG, 0);
	        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 4096);
	        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
	        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 40960);
	        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

	        return new DefaultKafkaProducerFactory<String, String>(properties);
	    }
}
