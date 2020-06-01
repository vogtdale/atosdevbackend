package com.atos.project.controllers;

import com.atos.project.model.Competence;
import com.atos.project.security.services.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CompetenceController {
    
    CompetenceService competenceService;
    
    @Autowired
    public CompetenceController(final CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    /*******************************************************
     *                      List of Competence
     *******************************************************/
    @GetMapping("/competences")
    public List<Competence> showCompetence() {
        return this.competenceService.findAll();
    }

    @GetMapping("/competences/{id}")
    public Competence getcomp(@PathVariable int id) {
        return (Competence) this.competenceService.findById(id);
    }


    /*******************************************************
     *                     Add Competence
     *******************************************************/
    @PutMapping("/addcomp")
    public Competence addcomp(@RequestBody Competence competences) {
        return this.competenceService.save(competences);
    }

    /******************************************************
     *                      Delete Competence
     *******************************************************/

    @DeleteMapping("/delcomp/{id}")
    public void delete(@PathVariable int id) {
        this.competenceService.delete(id);
    }
}
