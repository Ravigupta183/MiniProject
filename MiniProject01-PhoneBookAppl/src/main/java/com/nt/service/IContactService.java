package com.nt.service;

import java.util.List;


import com.nt.entity.Contact;

public interface IContactService {
	
	public String saveContact(Contact contact);
	public List<Contact> displayAllContacts();
	public Contact displayContactsById(Integer cid);
	public String updateContact(Contact contact);
	public String deleteContactById(Integer cid);
	
}
