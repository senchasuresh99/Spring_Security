package com.security.springsecurity2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	/**
	 * Below is the default security Configurations 
	 */
	
//	 @SuppressWarnings("removal") 
//	 @Bean
//	 SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception { http.authorizeHttpRequests().anyRequest().authenticated();
//	 http.formLogin(); http.httpBasic(); return http.build();
//	 }

	
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
	
//	/**
//	 * Configuration to deny all the request
//	 */
//	
//	@SuppressWarnings("removal") 
//	 @Bean
//	 SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests().anyRequest().denyAll()
//		.and().formLogin()
//	    .and().httpBasic();
//		return http.build();
//	 }
	
//	/**
//	 * Configuration to permitAll  the request
//	 */
//	
//	@SuppressWarnings("removal") 
//	 @Bean
//	 SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests().anyRequest().permitAll()
//		.and().formLogin()
//	    .and().httpBasic();
//		return http.build();
//	 }
}
