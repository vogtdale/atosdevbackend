package com.atos.project.security.services;

import com.atos.project.model.Agence;
import com.atos.project.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    
    @Autowired
    AgenceRepository agenceRepository;

    /*List Tous les agence*/
    public List<Agence> getAll() {
        return this.agenceRepository.findAll();
    }

    public Agence addAgence(Agence cagence) {
        return this.agenceRepository.save(cagence);
    }

    public Agence findById(Integer id) {
        return this.agenceRepository.findById(id).get();
    }

    public List<Agence> findAll() {
        return this.agenceRepository.findAll();
    }

    public Agence save(Agence cagence) {
        return this.agenceRepository.save(cagence);
    }

    public void delete(Integer id) {
        this.agenceRepository.deleteById(id);
    }
}
