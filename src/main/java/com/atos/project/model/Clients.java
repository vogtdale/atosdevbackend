package com.atos.project.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(	name = "clients")
@EntityListeners(AuditingEntityListener.class)
public class Clients {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.DATE)
    Date dateCreation;

    @Column(name="CLIENTNAME", nullable = true, length = 255)
    private String name;

    @Column(name="ADDRESSE", nullable = true, length = 255)
    private String addresse;

    @Column(name="SITE", nullable = true, length = 255)
    private String site;


    @Column(name="COMPETENCE", nullable = true, length = 255)
    private String competence;

    @Column(name="CONTACT", nullable = true, length = 255)
    private String contact;

    @Column(name="TEL", nullable = true, length = 255)
    private String tel;

    @Column(name="EMAIL", nullable = true, length = 255)
    private String email;

    @Column(name="PROPOSITION", nullable = true, length = 255)
    private String proposition;

    public Clients(){}
    public Clients(Integer id, Date dateCreation, String name, String addresse, String site, String competence, String contact, String tel, String email, String proposition) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.name = name;
        this.addresse = addresse;
        this.site = site;
        this.competence = competence;
        this.contact = contact;
        this.tel = tel;
        this.email = email;
        this.proposition = proposition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }
}
