package com.security.springsecurity3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.springsecurity3.model.Customer;
import com.security.springsecurity3.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer costomer){
		Customer savedCustomer =null;
		@SuppressWarnings("rawtypes")
		ResponseEntity response = null;
		try {
			savedCustomer=customerRepository.save(costomer);
			if(savedCustomer.getId()>0) {
				response=ResponseEntity .status(HttpStatus.CREATED).body("Given user details are successfully Registered");
			}
		} catch (Exception e) {
			response=ResponseEntity .status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured to"+e.getMessage());
		}
		return response;
	}
}
