package com.atos.project.controllers;

import com.atos.project.model.Experience;
import com.atos.project.security.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ExperienceController {
    
    ExperienceService experienceService;
    
    @Autowired
    public ExperienceController(final ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    /*******************************************************
     *                      List of Experience
     *******************************************************/
    @GetMapping("/exp")
    public List<Experience> showExperience() {
        return this.experienceService.findAll();
    }

    @GetMapping("/exp/{id}")
    public Experience getExp(@PathVariable int id) {
        return (Experience) this.experienceService.findById(id);
    }


    /*******************************************************
     *                     Add Experience
     *******************************************************/
    @PutMapping("/addexp")
    public Experience addexp(@RequestBody Experience experience) {
        return this.experienceService.save(experience);
    }

    /******************************************************
     *                      Delete Experience
     *******************************************************/

    @DeleteMapping("/delexp/{id}")
    public void delete(@PathVariable int id) {
        this.experienceService.delete(id);
    }
}
