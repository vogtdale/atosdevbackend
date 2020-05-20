package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Proposition")
@EntityListeners(AuditingEntityListener.class)
public class Proposition {

    @Column(name = "id_pro")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="idBsn")
    private Besoin besoin;

    @Column(name="d_pro")
    @Temporal(TemporalType.DATE)
    private Date d_pro;

    @ManyToOne
    @JoinColumn(name = "idClb")
    private Collaborateur collaborateur;

    @Column
    private float prixAchat;

    @Column
    private float prixVente;

    private float marge;

    @Column(name="d_relance")
    @Temporal(TemporalType.DATE)
    private Date d_relance;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @CreationTimestamp
    @Column(name="ts", nullable = false, updatable = false, insertable = false)
    private Date ts;

    @ManyToOne
    @JoinColumn(name = "idSpr")
    private StatutProposition statut_prop;



}
