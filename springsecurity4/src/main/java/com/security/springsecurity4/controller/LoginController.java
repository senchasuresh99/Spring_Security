package com.security.springsecurity4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.springsecurity4.model.Customer;
import com.security.springsecurity4.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@SuppressWarnings("unchecked")
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer costomer) {
		Customer savedCustomer = null;
		@SuppressWarnings("rawtypes")
		ResponseEntity response = null;
		try {
			String hashPass = passwordEncoder.encode(costomer.getPwd());
			costomer.setPwd(hashPass);
			savedCustomer = customerRepository.save(costomer);
			if (savedCustomer.getId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED)
						.body("Given user details are successfully Registered");
			}
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured to" + e.getMessage());
		}
		return response;
	}
}
