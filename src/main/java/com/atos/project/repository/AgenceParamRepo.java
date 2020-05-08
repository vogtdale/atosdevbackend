package com.atos.project.repository;

import com.atos.project.model.AgenceParametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceParamRepo extends JpaRepository<AgenceParametre, Integer> {
}
