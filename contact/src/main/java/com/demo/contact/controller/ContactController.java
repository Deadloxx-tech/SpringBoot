package com.demo.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.contact.model.Contact;
import com.demo.contact.service.ContactService;

import ch.qos.logback.core.model.Model;


@Controller
public class ContactController {

    @Autowired
    private ContactService service;

    //  List All Contacts
    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("list", service.getAllContacts());
        return "index";
    }

    //  Add Contact Form
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add";
    }

    //  Save Contact
    @PostMapping("/save")
    public String save(@ModelAttribute Contact contact) {
        service.saveContact(contact);
        return "redirect:/";
    }

    //  Delete Contact
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteContact(id);
        return "redirect:/";
    }

    // View Specific Contact
    @GetMapping("/contact/{id}")
    public String viewContact(@PathVariable int id, Model model) {
        model.addAttribute("contact", service.getContactById(id));
        return "view";
    }

    // Search Contact
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("list", service.searchByName(keyword));
        return "index";
    }
}    
    

