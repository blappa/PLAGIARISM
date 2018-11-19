/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.genilo.plagia_iss.Entities.Utilisateur;

/**
 *
 * @author lappa
 */
public interface IUtilisateur extends IDao<Utilisateur, Long>{
    
     public Utilisateur findByNom(String nom) throws DataAccessException;
   
}
