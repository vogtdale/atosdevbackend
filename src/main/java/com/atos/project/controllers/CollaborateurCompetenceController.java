package com.atos.project.controllers;

import com.atos.project.model.CollaborateurCompetence;
import com.atos.project.security.services.CollaborateurCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CollaborateurCompetenceController {
    CollaborateurCompetenceService collaborateurCompetenceService;

    @Autowired
    public CollaborateurCompetenceController(final CollaborateurCompetenceService collaborateurCompetenceServiceService) {
        this.collaborateurCompetenceService = collaborateurCompetenceServiceService;
    }

    /*******************************************************
     *                      List of CollaborateurCompetence
     *******************************************************/
    @GetMapping("/clb_cpc")
    public List<CollaborateurCompetence> showclb_cpc() {
        return this.collaborateurCompetenceService.findAll();
    }

    @GetMapping("/clb_cpc/{id}")
    public CollaborateurCompetence getclb_cpc(@PathVariable int id) {
        return (CollaborateurCompetence) this.collaborateurCompetenceService.findById(id);
    }

    /*******************************************************
     *                     Add CollaborateurCompetence
     *******************************************************/
    @PutMapping("/addclb_cpc")
    public CollaborateurCompetence addcollab(@RequestBody CollaborateurCompetence collaborateurCompetence) {
        return this.collaborateurCompetenceService.save(collaborateurCompetence);
    }

    /******************************************************
     *                      Delete CollaborateurCompetence
     *******************************************************/

    @DeleteMapping("/delclb_cpc/{id}")
    public void delete(@PathVariable int id) {
        this.collaborateurCompetenceService.delete(id);
    }
}
