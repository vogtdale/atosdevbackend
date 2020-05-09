package com.atos.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="type_competence")
@EntityListeners(AuditingEntityListener.class)
public class TypeCompetence {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="lib")
    @Size(max = 100)
    private String lib;


    @OneToMany(mappedBy = "typeCompetence")
    @JsonIgnore
    private Set<Competence> cpc = new HashSet<>();

    public TypeCompetence() {}

    public TypeCompetence(Integer id, String lib) {
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

    public Set<Competence> getCpc() {
        return cpc;
    }

    public void setCpc(Set<Competence> cpc) {
        this.cpc = cpc;
    }
}
