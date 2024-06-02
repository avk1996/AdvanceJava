package com.app.security_practiceII.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role-based-auth")
public class RoleController {
	
	@GetMapping("/home")
	public String home() {
		return ("<h1>Welcome to home</h1>");
	}
	
	@GetMapping("/user")
	public String userEndPoint() {
		return "<h1>Welcome User</h1>";
	}
	
	@GetMapping("/admin")
	public String adminEndPoint() {
		return "<h1>Welcome Admin</h1>";
	}

}
