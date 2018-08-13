package com.learnbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnbootkafka.producer.ProducerKafka;

@RestController
public class HomeController {
	@Autowired
	Environment env;
	
	@Autowired
	ProducerKafka producerKafka;
	
	@RequestMapping(value="/home")
	public String getResponse(@RequestParam("input") String value) {
		producerKafka.sendMessage(value);

		return env.getProperty("message.response");
	}

}
