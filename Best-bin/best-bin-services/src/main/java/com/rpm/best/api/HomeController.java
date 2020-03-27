package com.rpm.best.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String index() {
		return "Greetings from Best Bin Services!";
	}
	
	@RequestMapping("/getTest0")
	public String getTest0() {
		logger.debug("Getting all customers.");
		return "api/customer/getTest0";
	}

	@GetMapping("/getTest")
	public String getTest() {
		logger.debug("Getting all customers.");
		return "api/customer/getTest";
	}
	@GetMapping(value ="/getTest1")
	public String getTest1() {
		logger.debug("Getting all customers.");
		return "api/customer/getTest1";
	}
}
