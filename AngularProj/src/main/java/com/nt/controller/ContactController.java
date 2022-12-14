package com.nt.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Contact;

@RestController
@CrossOrigin
public class ContactController {
	
	private Map<Integer,Contact> contactMap=
			                 new HashMap();
	
	@PostMapping("/contact")
	public Collection<Contact> createContact(@RequestBody Contact c) {
		System.out.println(c);
		contactMap.put(UUID.randomUUID().hashCode(), c);
		
		return contactMap.values();
	}
	
}
