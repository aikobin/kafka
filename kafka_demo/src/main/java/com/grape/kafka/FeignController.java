package com.grape.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试contoller
 *
 * @author bin
 * @version 1.0 2018年4月4日 下午3:21:47
 */
@Controller
public class FeignController {
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;

	@RequestMapping("/testKafka")
	@ResponseBody
	public void testkafka(String message) {
		kafkaTemplate.send("binTopic", message);
	}

}
