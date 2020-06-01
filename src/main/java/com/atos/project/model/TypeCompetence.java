package com.atos.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "type_competence")
@EntityListeners(AuditingEntityListener.class)
public class TypeCompetence {

    @Column(name = "id_tcp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTcp;

    @Column(name = "lib")
    @Size(max = 100)
    private String lib;


    public TypeCompetence() {
    }

    public TypeCompetence(Integer idTcp, String lib) {
        this.idTcp = idTcp;
        this.lib = lib;
    }

    public Integer getId() {
        return idTcp;
    }

    public void setId(Integer id) {
        this.idTcp = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }
}
