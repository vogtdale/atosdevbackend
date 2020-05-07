package com.atos.project.controllers;

import com.atos.project.model.Besoin;
import com.atos.project.security.services.BesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BesoinController {
    
    BesoinService besoinService;
    
    @Autowired
    public BesoinController(final BesoinService besoinService ) {this.besoinService = besoinService;}

    /*******************************************************
     *                      List of Besoin
     *******************************************************/
    @GetMapping("/besoins")
    public List<Besoin> showBesoin() {
        return this.besoinService.findAll();
    }

    @GetMapping("/besoins/{id}")
    public Besoin getEvt(@PathVariable int id) {
        return (Besoin) this.besoinService.findById(id);
    }


    /*******************************************************
     *                     Add Besoin
     *******************************************************/
    @PutMapping("/addBesoin")
    public Besoin addUsers(@RequestBody Besoin besoins) {
        return this.besoinService.save(besoins);
    }

    /******************************************************
     *                      Delete Besoin
     *******************************************************/

    @DeleteMapping("/besoins/{id}")
    public void delete(@PathVariable int id) {
        this.besoinService.delete(id);
    }
}
