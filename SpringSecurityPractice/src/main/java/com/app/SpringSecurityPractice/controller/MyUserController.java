package com.app.SpringSecurityPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringSecurityPractice.entity.MyUser;
import com.app.SpringSecurityPractice.repository.MyUserRepository;

@RestController
public class MyUserController {

	@Autowired
	private MyUserRepository myUserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register/user")
	public MyUser createUser(@RequestBody MyUser myUser) {
		myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
		return myUserRepository.save(myUser);
	}

}
