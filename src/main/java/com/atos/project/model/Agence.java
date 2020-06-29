package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="agence")
@EntityListeners(AuditingEntityListener.class)
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private int idAgc;
    @Column(unique = true)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private String lib;

    @OneToMany(mappedBy="agence",fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, targetEntity = Collaborateur.class)
    @JsonView(MyJsonView.SiteClient.class)
    private List<Collaborateur> collab = new ArrayList<>();

    public Integer getId() {
        return idAgc;
    }
    public void setId(Integer id) { this.idAgc = idAgc; }
    public String getLib() {
        return lib;
    }
    public void setLib(String lib) {
        this.lib = lib;
    }

    public int getIdAgc() {
        return idAgc;
    }

    public void setIdAgc(int idAgc) {
        this.idAgc = idAgc;
    }

    public List<Collaborateur> getCollab() {
        return collab;
    }

    public void setCollab(List<Collaborateur> collab) {
        this.collab = collab;
    }
}
