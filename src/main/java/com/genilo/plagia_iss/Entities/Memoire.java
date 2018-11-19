/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.hibernate.annotations.Columns;

/**
 *
 * @author lappa
 */
@Entity
public class Memoire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nom_fichier;
    private String niveau;
    private String descriptionFr;
    private String descriptionEn;
    private String auteur;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_soutenance;
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Utilisateur utilisateur;
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Cathegorie cathegorie;

    public Memoire() {
    }

    public Memoire(String nom_fichier, String descriptionFr, String descriptionEn, Date date_soutenance, Cathegorie cathegorie, Utilisateur utilisateur) {
        this.nom_fichier = nom_fichier;
        this.descriptionFr = descriptionFr;
        this.descriptionEn = descriptionEn;
        this.date_soutenance = date_soutenance;
        this.cathegorie = cathegorie;
        this.utilisateur=utilisateur;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_fichier() {
        return nom_fichier;
    }

    public void setNom_fichier(String nom_fichier) {
        this.nom_fichier = nom_fichier;
    }

    public String getDescriptionFr() {
        return descriptionFr;
    }

    public void setDescriptionFr(String descriptionFr) {
        this.descriptionFr = descriptionFr;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public Date getDate_soutenance() {
        return date_soutenance;
    }

    public void setDate_soutenance(Date date_soutenance) {
        this.date_soutenance = date_soutenance;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Cathegorie getCathegorie() {
        return cathegorie;
    }

    public void setCathegorie(Cathegorie cathegorie) {
        this.cathegorie = cathegorie;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "com.genilo.plagia_iss.Entities.Memoire[ id=" + id + " ]";
    }
    
}
