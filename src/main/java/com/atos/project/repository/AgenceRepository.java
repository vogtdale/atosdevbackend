package com.atos.project.repository;

import com.atos.project.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer> {
}
