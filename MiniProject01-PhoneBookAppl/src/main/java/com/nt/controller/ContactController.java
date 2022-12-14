package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Contact;
import com.nt.service.IContactService;

@RestController
public class ContactController {

	@Autowired
	private IContactService service;
	
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact c) {
		return service.saveContact(c);
	}
	
	@GetMapping("/contacts")
	public List<Contact>  getAllContact(){
		return service.displayAllContacts();
	}
	@GetMapping("/contact/{cid}")
	public Contact getContactByid(@PathVariable Integer cid) {
		return service.displayContactsById(cid);
	}
	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact c) {
		return service.updateContact(c);
	}
	@DeleteMapping("/contact/{cid}")
	public String deleteContact(@PathVariable Integer cid) {
		return service.deleteContactById(cid);
	}
	
	
}
