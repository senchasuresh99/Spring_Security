package com.security.springsecurity2.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LonasController {
	
	@GetMapping("/myLona")
	public String getLonasDetails() {
		return "Here are the Lonas details from the DB";
	}
}
