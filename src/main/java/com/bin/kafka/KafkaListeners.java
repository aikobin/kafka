package com.bin.kafka;

import java.util.Optional;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Topic监听器 
 *
 * @author bin
 * @version 1.0 2018年4月4日 下午3:23:09
 */
public class KafkaListeners {
	@KafkaListener(topics = { "binTopic" })
	public void testListener(ConsumerRecord<?, ?> record) {

		Optional<?> messages = Optional.ofNullable(record.value());

		if (messages.isPresent()) {
			Object msg = messages.get();
			System.out.println("  this is the binTopic send message: " + msg);
		}
	}
}
