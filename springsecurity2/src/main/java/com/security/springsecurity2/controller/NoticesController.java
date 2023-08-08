package com.security.springsecurity2.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
	
	@GetMapping("/notice")
	public String getNoticesDetails() {
		return "Here are the Notices details from the DB";
	}
}
