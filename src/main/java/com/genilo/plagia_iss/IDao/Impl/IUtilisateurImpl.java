/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.genilo.plagia_iss.Entities.Utilisateur;
import com.genilo.plagia_iss.IDao.IUtilisateur;

/**
 *
 * @author lappa
 */
public class IUtilisateurImpl extends GenericDao<Utilisateur, Long> implements IUtilisateur{

    public Utilisateur findByNom(String nom) throws DataAccessException {
        return (Utilisateur)getManager().createQuery("SELECT u FROM Utilisateur u WHERE u.nom = :nom")
         .setParameter("nom", nom).getSingleResult();  
    }
    
}
