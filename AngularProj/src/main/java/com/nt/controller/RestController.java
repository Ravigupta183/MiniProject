package com.nt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class RestController {
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		String msg = "Jai shree Ram";
		return msg;
	}
	@GetMapping("/wish")
	public String getWishMessage() {
		return "All the best";
	}
	
}
