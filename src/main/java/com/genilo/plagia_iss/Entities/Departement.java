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
public class Departement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom;
    private String sigle;
    
    @JoinColumn(nullable = true)
    @OneToOne(fetch = FetchType.EAGER)
    private Utilisateur utilisateur;
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Etablissement etablissement;
     @OneToMany(mappedBy = "departement")
    private List<Plagia> plagias;

    public Departement() {
    }

    public Departement(String nom, String sigle, Etablissement etablissement) {
        this.nom = nom;
        this.sigle = sigle;
        this.etablissement = etablissement;
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

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public List<Plagia> getPlagias() {
        return plagias;
    }

    public void setPlagias(List<Plagia> plagias) {
        this.plagias = plagias;
    }

    @Override
    public String toString() {
        return nom+" "+sigle;
    }
    
}
