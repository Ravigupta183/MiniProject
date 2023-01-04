package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Contact;
import com.nt.repository.IContactRepo;
@Service("contactService")
public class ContactServiceImpl implements IContactService {

	@Autowired
	private IContactRepo repo;
	
	@Override
	public String saveContact(Contact contact) {
		
		contact = repo.save(contact);
		if(contact.getCid() != null)
		   return "Contact saved with::";
		else
			return "Contact failed to save";
	}

	@Override
	public List<Contact> displayAllContacts() {
		return repo.findAll();
	}

	@Override
	public Contact displayContactsById(Integer cid) {
		Optional<Contact> findById = repo.findById(cid);
		
		if(findById.isPresent())
		    return findById.get();
		else
			return null;
	}

	@Override
	public String updateContact(Contact contact) {
		Optional<Contact> opt = repo.findById(contact.getCid());
		if(opt.isPresent()) {
			repo.save(contact);
			return "Updated successful";
		}else {
		    return "record not found";
		}
	}

	@Override
	public String deleteContactById(Integer cid) {
		Optional<Contact> opt = repo.findById(cid);
		if(opt.isPresent()) {
			repo.deleteById(cid);
			return "Record deleted having id::"+cid;
		}else {
			return "Record not found for deletion";
		}
	}

}
