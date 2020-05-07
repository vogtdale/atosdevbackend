package com.atos.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="type_competence")
@EntityListeners(AuditingEntityListener.class)
public class TypeCompetence {

    @Column(name = "id",unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="lib")
    @Size(max = 100)
    private String lib;

    public TypeCompetence() {}

    public TypeCompetence(Integer id, @Size(max = 100) String lib) {
        this.id = id;
        this.lib = lib;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }
}