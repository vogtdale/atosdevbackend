package com.atos.project.controllers;

import com.atos.project.model.Collaborateur;
import com.atos.project.security.services.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CollaborateurController {
    
    CollaborateurService collaborateurService;
    
    @Autowired
    public CollaborateurController(final CollaborateurService collaborateurService) {
        this.collaborateurService = collaborateurService;
    }

    /*******************************************************
     *                      List of Collaborateur
     *******************************************************/
    @GetMapping("/collaborateur")
    public List<Collaborateur> showCollaborateur() {
        return this.collaborateurService.findAll();
    }

    @GetMapping("/collaborateur/{id}")
    public Collaborateur getCollab(@PathVariable int id) {
        return (Collaborateur) this.collaborateurService.findById(id);
    }


    /*******************************************************
     *                     Add Collaborateur
     *******************************************************/
    @PutMapping("/addCollaborateur")
    public Collaborateur addcollab(@RequestBody Collaborateur collaborateur) {
        return this.collaborateurService.save(collaborateur);
    }

    /******************************************************
     *                      Delete Collaborateur
     *******************************************************/

    @DeleteMapping("/collaborateur/{id}")
    public void delete(@PathVariable int id) {
        this.collaborateurService.delete(id);
    }
}
