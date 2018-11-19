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
public class Cathegorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom;
    
    @OneToMany(mappedBy = "cathegorie")
    private List<Memoire> memoires;

    public Cathegorie() {
    }

    public Cathegorie(String nom) {
        this.nom = nom;
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

    public List<Memoire> getMemoires() {
        return memoires;
    }

    public void setMemoires(List<Memoire> memoires) {
        this.memoires = memoires;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
