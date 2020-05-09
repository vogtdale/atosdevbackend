package com.atos.project.controllers;

import com.atos.project.model.StatutProposition;
import com.atos.project.security.services.StatutPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StatutController {
    
    StatutPropService statutPropService;
    
    @Autowired
    public StatutController(final StatutPropService statutPropService) {
        this.statutPropService = statutPropService;
        
    }


    /*******************************************************
     *                      List of StatutProposition
     *******************************************************/
    @GetMapping("/statuts")
    public List<StatutProposition> showStatutProposition() {
        return this.statutPropService.findAll();
    }

    @GetMapping("/statuts/{id}")
    public StatutProposition getstatus(@PathVariable int id) {
        return (StatutProposition) this.statutPropService.findById(id);
    }


    /*******************************************************
     *                     Add StatutProposition
     *******************************************************/
    @PutMapping("/addStatutProposition")
    public StatutProposition addstatus(@RequestBody StatutProposition statuts) {
        return this.statutPropService.save(statuts);
    }

    /******************************************************
     *                      Delete StatutProposition
     *******************************************************/

    @DeleteMapping("/statuts/{id}")
    public void delete(@PathVariable int id) {
        this.statutPropService.delete(id);
    }
}
