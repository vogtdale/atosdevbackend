package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Collaborateur")
@EntityListeners(AuditingEntityListener.class)
public class Collaborateur {
    @Id
    @Column(name="id_clb")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private Integer idClb;

    @NotBlank
    @Size(max = 100)
    @JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private String nom;

    @NotBlank
    @Size(max = 100)
    @JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private String prenom;

    @Size(max = 50)
    @Email
    @JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private String email;

    @NotBlank
    @Size(max = 50)
    @JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private String matricule;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAgc")
    @JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private Agence agence;

    @JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private boolean f_dispo;

    @JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private boolean f_actif;

    @OneToMany(mappedBy="collaborateur",fetch=FetchType.LAZY,cascade=CascadeType.ALL, targetEntity = CollaborateurCompetence.class)
    @JsonView({MyJsonView.Collaborateur.class})
    private List<CollaborateurCompetence> listeCollaborateurCompetence = new ArrayList<>();

    public Integer getIdClb() {
        return idClb;
    }

    public void setIdClb(Integer idClb) {
        this.idClb = idClb;
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public boolean isF_dispo() {
        return f_dispo;
    }

    public void setF_dispo(boolean f_dispo) {
        this.f_dispo = f_dispo;
    }

    public boolean isF_actif() {
        return f_actif;
    }

    public void setF_actif(boolean f_actif) {
        this.f_actif = f_actif;
    }

    public List<CollaborateurCompetence> getListeCollaborateurCompetence() {
        return listeCollaborateurCompetence;
    }

    public void setListeCollaborateurCompetence(List<CollaborateurCompetence> listeCollaborateurCompetence) {
        this.listeCollaborateurCompetence = listeCollaborateurCompetence;
    }
}
