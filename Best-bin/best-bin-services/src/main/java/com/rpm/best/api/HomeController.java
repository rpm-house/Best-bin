package com.rpm.best.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping("/")
	public String index() {
		return "Greetings from Best Bin Services!";
	}
	
	@RequestMapping("/getTest0")
	public String getTest0() {
		return "api/customer/getTest0";
	}

	@GetMapping("/getTest")
	public String getTest() {
		return "api/customer/getTest";
	}
	@GetMapping(value ="/getTest1")
	public String getTest1() {
		return "api/customer/getTest1";
	}
}
