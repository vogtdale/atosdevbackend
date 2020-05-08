package com.atos.project.security.services;

import com.atos.project.model.AgenceParametre;
import com.atos.project.repository.AgenceParamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceParamService {

    @Autowired
    AgenceParamRepo agenceParamRepo;

    /*List Tous les agence*/
    public List<AgenceParametre> getAll() {
        return this.agenceParamRepo.findAll();
    }

    public AgenceParametre addAgenceParametre(AgenceParametre param) {
        return this.agenceParamRepo.save(param);
    }

    public AgenceParametre findById(Integer id) {
        return this.agenceParamRepo.findById(id).get();
    }

    public List<AgenceParametre> findAll() {
        return this.agenceParamRepo.findAll();
    }

    public AgenceParametre save(AgenceParametre param) {
        return this.agenceParamRepo.save(param);
    }

    public void delete(Integer id) {
        this.agenceParamRepo.deleteById(id);
    }
}
