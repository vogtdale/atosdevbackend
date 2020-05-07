package com.atos.project.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="statut_prop")
@EntityListeners(AuditingEntityListener.class)
public class StatutProposition {

    @Column(name = "ID",unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(max=100)
    private String lib;

    @Size(max=11)
    private int ordr;

    public StatutProposition(Integer id, String lib, int ordr) {
        this.id = id;
        this.lib = lib;
        this.ordr = ordr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public int getOrdr() {
        return ordr;
    }

    public void setOrdr(int ordr) {
        this.ordr = ordr;
    }
}
