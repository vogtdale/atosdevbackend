package com.atos.project.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Besoin")
@EntityListeners(AuditingEntityListener.class)
public class Besoin {

    @Column(name = "Id")
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
    @Column(name="ts")
    private Date ts;

    @Column(name="remarque")
    @Size(max = 1000)
    private String remarque;


    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "besoin_competence",
            joinColumns = @JoinColumn(name = "id_bsn"),
            inverseJoinColumns = @JoinColumn(name = "id_cpc"))
    private Set<Competence> comp = new HashSet<>();

    @ManyToMany(mappedBy = "besoins",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Experience> exp = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="id_site")
    private Site site;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="id_ctc")
    private ContactClient contactClient;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="id_usr")
    private User user;

    @OneToMany(mappedBy = "besoinListe", fetch = FetchType.LAZY )
    @JsonIgnore
    private Set<Proposition> prop = new HashSet<>();

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

    public Set<Competence> getCompetences() {
        return comp;
    }

    public void setCompetences(Set<Competence> competences) {
        this.comp = competences;
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

    public Set<Competence> getComp() {
        return comp;
    }

    public void setComp(Set<Competence> comp) {
        this.comp = comp;
    }

    public Set<Experience> getExp() {
        return exp;
    }

    public void setExp(Set<Experience> exp) {
        this.exp = exp;
    }

    public Set<Proposition> getProp() {
        return prop;
    }

    public void setProp(Set<Proposition> prop) {
        this.prop = prop;
    }
}
