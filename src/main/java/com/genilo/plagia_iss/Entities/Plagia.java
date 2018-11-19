/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author lappa
 */
@Entity
public class Plagia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int nbre_plagia;
    private String annee;
    
    @JoinColumn(nullable = true)
    @OneToOne(fetch = FetchType.EAGER)
    private Departement departement;
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Utilisateur utilisateur;

    public Plagia() {
    }

    public Plagia(int nbre_plagia, String annee, Departement departement, Utilisateur utilisateur) {
        this.nbre_plagia = nbre_plagia;
        this.annee = annee;
        this.departement = departement;
        this.utilisateur = utilisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbre_plagia() {
        return nbre_plagia;
    }

    public void setNbre_plagia(int nbre_plagia) {
        this.nbre_plagia = nbre_plagia;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return annee+" "+departement.getNom()+" "+utilisateur.getNom();
    }
    
}
