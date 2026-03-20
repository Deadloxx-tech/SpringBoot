package com.demo.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.contact.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByNameContainingIgnoreCase(String name);

}