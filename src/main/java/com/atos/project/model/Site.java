package com.atos.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Site")
@EntityListeners(AuditingEntityListener.class)
public class Site {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Size(max = 100)
    private String lib;

    @NotBlank
    @Size(max = 100)
    private String adr;


    @Size(max = 100)
    @Column(name ="code_postal")
    private String codepostale;

    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String tel;

    @Size(max = 100)
    private String fax;

    @Size(max = 100)
    @Column(name ="ville")
    private String ville;


    @OneToMany(mappedBy = "site")
    @JsonIgnore
    private Set<Besoin> besoin = new HashSet<>();


    @OneToMany(mappedBy = "site")
    private Set<ContactClient> ctc = new HashSet<>();


    public Site() {}

    public Site(Integer id, String lib, String adr, String codepostale, String email, String tel, String fax, String ville) {
        this.id = id;
        this.lib = lib;
        this.adr = adr;
        this.codepostale = codepostale;
        this.email = email;
        this.tel = tel;
        this.fax = fax;
        this.ville = ville;
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

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getCodepostale() {
        return codepostale;
    }

    public void setCodepostale(String codepostale) {
        this.codepostale = codepostale;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Set<Besoin> getBesoin() {
        return besoin;
    }

    public void setBesoin(Set<Besoin> besoin) {
        this.besoin = besoin;
    }

    public Set<ContactClient> getCtc() {
        return ctc;
    }

    public void setCtc(Set<ContactClient> ctc) {
        this.ctc = ctc;
    }
}
