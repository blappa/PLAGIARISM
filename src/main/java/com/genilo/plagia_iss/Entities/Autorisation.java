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
public class Autorisation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   private String droit;
   
    @OneToMany(mappedBy = "autorisation")
    private List<Utilisateur> utilisateur;


    public Autorisation() {
    }

    public Autorisation(String droit) {
        this.droit = droit;
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDroit() {
        return droit;
    }

    public void setDroit(String droit) {
        this.droit = droit;
    }

    public List<Utilisateur> getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(List<Utilisateur> utilisateur) {
        this.utilisateur = utilisateur;
    }


    @Override
    public String toString() {
        return droit;
    }
    
}
