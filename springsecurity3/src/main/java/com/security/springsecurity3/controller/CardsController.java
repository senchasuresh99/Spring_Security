package com.security.springsecurity3.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
	
	@GetMapping("/myCard")
	public String getCardsDetails() {
		return "Here are the Cards details from the DB";
	}
}
