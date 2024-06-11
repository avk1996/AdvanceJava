package com.app.SpringSecurityPractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String handleGreetings() {
		return "Welcome to Spring Security";
	}

	@GetMapping("/user/home")
	public String sayHello() {
		return "Hello user";
	}

	@GetMapping("/admin/home")
	public String sayHello(int randomNumber) {
		randomNumber = 5;
		return "Hello admin Rank: " + randomNumber;
	}

}
