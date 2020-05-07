package com.atos.project.model;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Besoin")
@EntityListeners(AuditingEntityListener.class)
public class Besoin {

    @Column(name = "Id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="d_debut")
    @Temporal(TemporalType.DATE)
    Date d_debut;

    @Column(name="intitule")
    @Size(max = 250)
    private String intitule;

    @Column(name="d_echeance")
    @Temporal(TemporalType.DATE)
    Date d_echeance;

    @CreationTimestamp
    @Column(name="ts", nullable = false, updatable = false, insertable = false)
    private Date ts;

    @Column(name="remarque")
    @Size(max = 1000)
    private String remarque;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "besoin_competence",
            joinColumns = @JoinColumn(name = "id_bsn"),
            inverseJoinColumns = @JoinColumn(name = "id_cpc"))
    private List<Competence> competences;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id_site")
    private Site site;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id_ctc")
    private ContactClient contactClient;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id_usr")
    private User user;

    public Besoin() {}

    public Besoin(Date d_debut, String intitule, Date d_echeance, Date ts, String remarque) {
        this.d_debut = d_debut;
        this.intitule = intitule;
        this.d_echeance = d_echeance;
        this.ts = ts;
        this.remarque = remarque;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getD_debut() {
        return d_debut;
    }

    public void setD_debut(Date d_debut) {
        this.d_debut = d_debut;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Date getD_echeance() {
        return d_echeance;
    }

    public void setD_echeance(Date d_echeance) {
        this.d_echeance = d_echeance;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public ContactClient getContactClient() {
        return contactClient;
    }

    public void setContactClient(ContactClient contactClient) {
        this.contactClient = contactClient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
