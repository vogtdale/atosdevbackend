package com.atos.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Proposition")
@EntityListeners(AuditingEntityListener.class)
public class Proposition {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="d_prop")
    @Temporal(TemporalType.DATE)
    private Date d_prop;

    @Column(name="d_relance")
    @Temporal(TemporalType.DATE)
    private Date d_relance;

    @CreationTimestamp
    @Column(name="ts", nullable = false, updatable = false, insertable = false)
    private Date ts;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="id_bsn")
    private Besoin besoinListe;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="id_clb")
    private Collaborateur collaborateurList;

    public Proposition() {}

    public Proposition(Integer id, Date d_prop, Date d_relance, Date ts) {
        this.id = id;
        this.d_prop = d_prop;
        this.d_relance = d_relance;
        this.ts = ts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getD_prop() {
        return d_prop;
    }

    public void setD_prop(Date d_prop) {
        this.d_prop = d_prop;
    }

    public Date getD_relance() {
        return d_relance;
    }

    public void setD_relance(Date d_relance) {
        this.d_relance = d_relance;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Besoin getBesoinListe() {
        return besoinListe;
    }

    public void setBesoinListe(Besoin besoinListe) {
        this.besoinListe = besoinListe;
    }

    public Collaborateur getCollaborateurList() {
        return collaborateurList;
    }

    public void setCollaborateurList(Collaborateur collaborateurList) {
        this.collaborateurList = collaborateurList;
    }


}
