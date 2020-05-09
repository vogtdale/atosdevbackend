package com.atos.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Agence")
@EntityListeners(AuditingEntityListener.class)
public class Agence {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Size(max = 100)
    private String lib;


    @OneToMany(mappedBy = "agence")
    @JsonIgnore
    private Set<Collaborateur> clb = new HashSet<>();

    public Agence() {}

    public Agence(Integer id, String lib) {
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

    public Set<Collaborateur> getClb() {
        return clb;
    }

    public void setClb(Set<Collaborateur> clb) {
        this.clb = clb;
    }
}
