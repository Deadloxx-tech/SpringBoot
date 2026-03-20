package com.demo.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.contact.model.Contact;
import com.demo.contact.repository.ContactRepository;
@Service
public class ContactService {
    
    @Autowired
    private  ContactRepository repo;


    public List<Contact> searchByName(String name) {
    return repo.findByNameContainingIgnoreCase(name);
}
    @GetMapping
    public List<Contact> getAllContacts() {
        return repo.findAll();
    }

    public void saveContact(Contact contact) {
        repo.save(contact);
    }

    public void deleteContact(int id) {
        repo.deleteById(id);
    }

    public Contact getContactById(int id) {
        return repo.findById(id).orElse(null);
}

}
