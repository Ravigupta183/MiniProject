package com.nt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Contact;

@RestController
@CrossOrigin
public class ContactController {
	
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact c) {
		System.out.println(c);
		return "Contact saved";
	}
	
}
