package com.app.SpringSecurityPractice.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.SpringSecurityPractice.entity.MyUser;
import com.app.SpringSecurityPractice.repository.MyUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private MyUserRepository myUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser> existingUser = myUserRepository.findByName(username);

		if (existingUser.isPresent()) {
			return User.builder().username(existingUser.get().getName()).password(existingUser.get().getPassword())
					.roles(getRoles(existingUser.get())).build();
		} else {
			throw new UsernameNotFoundException(username);
		}

	}

	private String[] getRoles(MyUser myUser) {
		if (myUser.getRole() == null) {
			return new String[] { "USER" };
		}
		return myUser.getRole().split(",");
	}
}
