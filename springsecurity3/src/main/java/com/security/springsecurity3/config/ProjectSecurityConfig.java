package com.security.springsecurity3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	/**
	 * Below is the custom security Configurations 
	 */
	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.requestMatchers("/myAccount","/myBalance","/myLoan","/myCard").authenticated()
		.requestMatchers("/notice","/contact").permitAll()
		.and().formLogin()
		.and().httpBasic();
		return http.build();
	}
	
//	@SuppressWarnings("deprecation")
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails admin = User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("12345")
//				.authorities("admin")
//				.build();
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("1234")
//				.authorities("read")
//				.build();
//		return new InMemoryUserDetailsManager(admin, user);
//	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.withUsername("admin")
				.password("12345")
				.authorities("admin")
				.build();
		UserDetails user = User.withUsername("user")
				.password("1234")
				.authorities("read")
				.build();
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
