/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lappa
 */
@Entity
public class Etablissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom_etab;
    private String sigle;
    
    @OneToMany(mappedBy = "etablissement")
    private List<Departement> departements;

    public Etablissement() {
    }

    public Etablissement(String nom_etab, String sigle) {
        this.nom_etab = nom_etab;
        this.sigle = sigle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_etab() {
        return nom_etab;
    }

    public void setNom_etab(String nom_etab) {
        this.nom_etab = nom_etab;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public List<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }
   
    @Override
    public String toString() {
        return nom_etab+" "+sigle;
    }
    
}
