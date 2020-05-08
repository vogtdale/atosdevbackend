package com.atos.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Experience")
@EntityListeners(AuditingEntityListener.class)
public class Experience {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="lib")
    @Size(max = 11)
    private String lib;

    @JsonIgnore
    @ManyToMany(mappedBy = "exp")
    private Set<Collaborateur> colb = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "besoin_competence",
            joinColumns = @JoinColumn(name = "id_exp"),
            inverseJoinColumns = @JoinColumn(name = "id_bsn"))
    private List<Besoin> besoins;

    public Experience() {}

    public Experience(Integer id, String lib) {
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

    public List<Besoin> getBesoins() {
        return besoins;
    }

    public void setBesoins(List<Besoin> besoins) {
        this.besoins = besoins;
    }

    public Set<Collaborateur> getColb() {
        return colb;
    }

    public void setColb(Set<Collaborateur> colb) {
        this.colb = colb;
    }
}
