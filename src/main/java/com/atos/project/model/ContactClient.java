package com.atos.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Contact_Client")
@EntityListeners(AuditingEntityListener.class)

public class ContactClient {
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
    @Size(max = 100)
    private String poste;

    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String tel;

    @Size(max = 100)
    private String fax;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="id_site")
    private Site site;


    @ManyToMany(fetch = FetchType.LAZY)

    @JoinTable(name = "contact_competence",
            joinColumns = @JoinColumn(name = "id_ctc"),
            inverseJoinColumns = @JoinColumn(name = "id_cpc"))
    private Set<Competence> competences = new HashSet<>();


    @OneToMany(mappedBy = "contactClient")
    private Set<Besoin> bsn = new HashSet<>();

    public ContactClient() {}

    public ContactClient(Integer id, String nom, String prenom, String poste, String email, String tel, String fax) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.email = email;
        this.tel = tel;
        this.fax = fax;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }

    public Set<Besoin> getBsn() {
        return bsn;
    }

    public void setBsn(Set<Besoin> bsn) {
        this.bsn = bsn;
    }


}
