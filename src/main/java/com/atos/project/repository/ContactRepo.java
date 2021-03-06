package com.atos.project.repository;

import com.atos.project.model.ContactClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<ContactClient, Integer> {
}
