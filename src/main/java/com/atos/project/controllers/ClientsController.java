package com.atos.project.controllers;


import com.atos.project.model.Clients;

import com.atos.project.security.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClientsController {

    ClientService clientService;


    @Autowired
    public ClientsController(final ClientService clientService) {
        this.clientService = clientService;
    }


    /*******************************************************
     *                      List of Clients
     *******************************************************/
    @GetMapping("/clients")
    public List<Clients> showClients() {
        return this.clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    public Clients getEvt(@PathVariable int id) {
        return (Clients) this.clientService.findById(id);
    }


    /*******************************************************
     *                     Add Clients
     *******************************************************/
    @PutMapping("/addClients")
    public Clients addUsers(@RequestBody Clients clients) {
        return this.clientService.save(clients);
    }

    /******************************************************
     *                      Delete Clients
     *******************************************************/

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable int id) {
        this.clientService.delete(id);
    }
}
