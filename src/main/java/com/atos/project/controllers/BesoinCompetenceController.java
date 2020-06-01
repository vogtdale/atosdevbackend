package com.atos.project.controllers;

import com.atos.project.model.BesoinCompetence;
import com.atos.project.security.services.BesoinCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BesoinCompetenceController {
    BesoinCompetenceService besoinCompetenceService;

    @Autowired
    public BesoinCompetenceController(final BesoinCompetenceService besoinCompetenceServiceService) {
        this.besoinCompetenceService = besoinCompetenceServiceService;
    }

    /*******************************************************
     *                      List of BesoinCompetence
     *******************************************************/
    @GetMapping("/bsn_cpc")
    public List<BesoinCompetence> showclb_cpc() {
        return this.besoinCompetenceService.findAll();
    }

    @GetMapping("/bsn_cpc/{id}")
    public BesoinCompetence getclb_cpc(@PathVariable int id) {
        return (BesoinCompetence) this.besoinCompetenceService.findById(id);
    }

    /*******************************************************
     *                     Add BesoinCompetence
     *******************************************************/
    @PutMapping("/addbsn_cpc")
    public BesoinCompetence addcollab(@RequestBody BesoinCompetence besoinCompetence) {
        return this.besoinCompetenceService.save(besoinCompetence);
    }

    /******************************************************
     *                      Delete BesoinCompetence
     *******************************************************/

    @DeleteMapping("/delbsn_cpc/{id}")
    public void delete(@PathVariable int id) {
        this.besoinCompetenceService.delete(id);
    }
    
}
