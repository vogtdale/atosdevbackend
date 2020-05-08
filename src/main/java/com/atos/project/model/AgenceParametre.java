package com.atos.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="Agence_parametre")
@EntityListeners(AuditingEntityListener.class)
public class AgenceParametre {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(name="nom_structure")
    private String nom;


    private String logo;

    public AgenceParametre() {}
    public AgenceParametre(Integer id, String nom, String logo) {
        this.id = id;
        this.nom = nom;
        this.logo = logo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
