package com.security.springsecurity5.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	/**
	 * Below is the custom security Configurations
	 */

	@SuppressWarnings("removal")

	@Bean
	SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/myAccount", "/myBalance", "/myLoan", "/myCard")
		.authenticated()
		.requestMatchers("/notice", "/contact","/register")
		.permitAll()
		.and()
		.formLogin()
		.and()
		.httpBasic();
		return http.build();
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
