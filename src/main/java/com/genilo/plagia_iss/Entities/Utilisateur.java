/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author lappa
 */
@Entity
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom;
    private String login;
    private String password;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Autorisation autorisation;
    @JoinColumn(nullable = true)
    @OneToOne(fetch = FetchType.EAGER)
    private Departement departement;
    @OneToMany(mappedBy = "utilisateur")
    private List<Memoire> memoires;
    @OneToMany(mappedBy = "utilisateur")
    private List<Plagia> plagias;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String login, String password, Autorisation autorisation, Departement departement) {
        this.nom = nom;
        this.login=login;
        this.password = password;
        this.autorisation = autorisation;
        this.departement = departement;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Autorisation getAutorisation() {
        return autorisation;
    }

    public void setAutorisation(Autorisation autorisation) {
        this.autorisation = autorisation;
    }
    

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Memoire> getMemoires() {
        return memoires;
    }

    public void setMemoires(List<Memoire> memoires) {
        this.memoires = memoires;
    }

    public List<Plagia> getPlagias() {
        return plagias;
    }

    public void setPlagias(List<Plagia> plagias) {
        this.plagias = plagias;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    @Override
    public String toString() {
        return nom;
    }
    
}
