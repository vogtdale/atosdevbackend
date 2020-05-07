package com.atos.project.controllers;

import com.atos.project.model.Experience;
import com.atos.project.security.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@CrossOrigin
public class ExperienceController {
    
    ExperienceService experienceService;
    
    @Autowired
    public ExperienceController(final ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    /*******************************************************
     *                      List of Experience
     *******************************************************/
    @GetMapping("/experience")
    public List<Experience> showExperience() {
        return this.experienceService.findAll();
    }

    @GetMapping("/experience/{id}")
    public Experience getExp(@PathVariable int id) {
        return (Experience) this.experienceService.findById(id);
    }


    /*******************************************************
     *                     Add Experience
     *******************************************************/
    @PutMapping("/addExperience")
    public Experience addexp(@RequestBody Experience experience) {
        return this.experienceService.save(experience);
    }

    /******************************************************
     *                      Delete Experience
     *******************************************************/

    @DeleteMapping("/experience/{id}")
    public void delete(@PathVariable int id) {
        this.experienceService.delete(id);
    }
}
