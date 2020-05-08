package com.atos.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Collaborateur")
@EntityListeners(AuditingEntityListener.class)
public class Collaborateur {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nom;

    @NotBlank
    @Size(max = 100)
    private String prenom;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 50)
    private String tel;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "collaborateur_competence",
            joinColumns = @JoinColumn(name = "id_clb"),
            inverseJoinColumns = @JoinColumn(name = "id_exp"))
    private Set<Experience> exp = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "collaborateur_competence",
            joinColumns = @JoinColumn(name = "id_clb"),
            inverseJoinColumns = @JoinColumn(name = "id_cpc"))
    private Set<Competence> competences = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id_bsn")
    private Agence agence;


    public Collaborateur() {}

    public Collaborateur(Integer id, String nom, String prenom, String email, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;

        this.email = email;
        this.tel = tel;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Set<Experience> getExp() {
        return exp;
    }

    public void setExp(Set<Experience> exp) {
        this.exp = exp;
    }

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }
}
