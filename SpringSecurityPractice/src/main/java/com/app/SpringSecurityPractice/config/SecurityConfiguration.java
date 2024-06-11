package com.app.SpringSecurityPractice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.app.SpringSecurityPractice.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
				.authorizeHttpRequests(registry -> {
					registry.requestMatchers("/home", "/register/**").permitAll();
					registry.requestMatchers("/admin/**").hasRole("ADMIN");
					registry.requestMatchers("/user/**").hasRole("USER");
					registry.anyRequest().authenticated();
				}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build();
	}

//	@Bean
//	UserDetailsService userDetailsService() {
//		UserDetails normalUser = User.builder().username("normal")
//				.password("$2a$12$U1kh5mllqA7RhDegdHCliOLmp.vs2.1fidphOSwVeCVpIfh8gyFke\r\n" + "").roles("USER")
//				.build();
//		UserDetails admin = User.builder().username("admin")
//				.password("$2a$12$U1kh5mllqA7RhDegdHCliOLmp.vs2.1fidphOSwVeCVpIfh8gyFke\r\n" + "")
//				.roles("ADMIN", "USER").build();
//
//		return new InMemoryUserDetailsManager(normalUser, admin);
//	}

	@Bean
	UserDetailsService userDetailsService() {
		return myUserDetailsService;
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(myUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
