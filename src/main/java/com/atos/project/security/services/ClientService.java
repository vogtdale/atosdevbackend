package com.atos.project.security.services;

import com.atos.project.model.Clients;
import com.atos.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    /*List Tous les clients*/
    public List<Clients> getAll() {
        return this.clientRepository.findAll();
    }

    public Clients addClient(Clients clients) {
        return this.clientRepository.save(clients);
    }

    public Clients findById(Integer id) {
        return this.clientRepository.findById(id).get();
    }

    public List<Clients> findAll() {
        return this.clientRepository.findAll();
    }

    public Clients save(Clients clients) {
        return this.clientRepository.save(clients);
    }

    public void delete(Integer id) {
        this.clientRepository.deleteById(id);
    }
}
