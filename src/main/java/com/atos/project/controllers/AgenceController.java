package com.atos.project.controllers;

import com.atos.project.model.Agence;
import com.atos.project.security.services.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AgenceController {
    
    AgenceService agenceService;
    
    @Autowired
    public AgenceController(final AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    /*******************************************************
     *                      List of Agence
     *******************************************************/
    @GetMapping("/agence")
    public List<Agence> showAgence() {
        return this.agenceService.findAll();
    }

    @GetMapping("/agence/{id}")
    public Agence getAgence(@PathVariable int id) {
        return (Agence) this.agenceService.findById(id);
    }


    /*******************************************************
     *                     Add Agence
     *******************************************************/
    @PutMapping("/addAgence")
    public Agence addUsers(@RequestBody Agence agence) {
        return this.agenceService.save(agence);
    }

    /******************************************************
     *                      Delete Agence
     *******************************************************/

    @DeleteMapping("/agence/{id}")
    public void delete(@PathVariable int id) {
        this.agenceService.delete(id);
    }
}
