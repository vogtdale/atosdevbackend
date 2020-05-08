package com.atos.project.controllers;

import com.atos.project.model.Agence;
import com.atos.project.model.AgenceParametre;
import com.atos.project.security.services.AgenceParamService;
import com.atos.project.security.services.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AgenceParamController {

    AgenceParamService agenceParamService;

    @Autowired
    public AgenceParamController(final AgenceParamService agenceParamService) {
        this.agenceParamService = agenceParamService;
    }

    /*******************************************************
     *                      List of AgenceParametre
     *******************************************************/
    @GetMapping("/param")
    public List<AgenceParametre> showAgence() {
        return this.agenceParamService.findAll();
    }

    @GetMapping("/param/{id}")
    public AgenceParametre getparm(@PathVariable int id) {
        return (AgenceParametre) this.agenceParamService.findById(id);
    }


    /*******************************************************
     *                     Add AgenceParametre
     *******************************************************/
    @PutMapping("/addparam")
    public AgenceParametre addparam(@RequestBody AgenceParametre agenceParametre) {
        return this.agenceParamService.save(agenceParametre);
    }

    /******************************************************
     *                      Delete AgenceParametre
     *******************************************************/

    @DeleteMapping("/param/{id}")
    public void delete(@PathVariable int id) {
        this.agenceParamService.delete(id);
    }
}
