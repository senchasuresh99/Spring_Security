package com.security.springsecurity5.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	
	@GetMapping("/contact")
	public String getContactDetails() {
		return "Here are the Contact details from the DB";
	}
}
