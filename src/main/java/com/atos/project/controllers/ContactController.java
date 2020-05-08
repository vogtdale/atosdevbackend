package com.atos.project.controllers;

import com.atos.project.model.ContactClient;
import com.atos.project.security.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ContactController {
    
    ContactService contactService;
    
    @Autowired
    public ContactController(final ContactService contactService) {
        this.contactService = contactService;
    }

    /*******************************************************
     *                      List of ContactClient
     *******************************************************/
    @GetMapping("/contacts")
    public List<ContactClient> showContactClient() {
        return this.contactService.findAll();
    }

    @GetMapping("/contacts/{id}")
    public ContactClient getcontact(@PathVariable int id) {
        return (ContactClient) this.contactService.findById(id);
    }


    /*******************************************************
     *                     Add ContactClient
     *******************************************************/
    @PutMapping("/addContactClient")
    public ContactClient addContact(@RequestBody ContactClient contacts) {
        return this.contactService.save(contacts);
    }

    /******************************************************
     *                      Delete ContactClient
     *******************************************************/

    @DeleteMapping("/contacts/{id}")
    public void delete(@PathVariable int id) {
        this.contactService.delete(id);
    }
}
