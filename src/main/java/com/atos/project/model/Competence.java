package com.atos.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Competence")
@EntityListeners(AuditingEntityListener.class)
public class Competence {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="lib")
    @Size(max=100)
    private String lib;



    @ManyToMany(mappedBy = "competences")
    @JsonIgnore
    private Set<Collaborateur> colb = new HashSet<>();


    @ManyToMany(mappedBy = "comp")
    @JsonIgnore
    private Set<Besoin> bsn = new HashSet<>();


    @ManyToMany(mappedBy = "competences")
    @JsonIgnore
    private Set<ContactClient> ctc = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="id_tcp")
    private TypeCompetence typeCompetence;

    public Competence() {}

    public Competence(Integer id, String lib) {
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

    public TypeCompetence getTypeCompetence() {
        return typeCompetence;
    }

    public void setTypeCompetence(TypeCompetence typeCompetence) {
        this.typeCompetence = typeCompetence;
    }

    public Set<Collaborateur> getColb() {
        return colb;
    }

    public void setColb(Set<Collaborateur> colb) {
        this.colb = colb;
    }

    public Set<Besoin> getBsn() {
        return bsn;
    }

    public void setBsn(Set<Besoin> bsn) {
        this.bsn = bsn;
    }

    public Set<ContactClient> getCtc() {
        return ctc;
    }

    public void setCtc(Set<ContactClient> ctc) {
        this.ctc = ctc;
    }
}
