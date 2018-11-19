/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.genilo.plagia_iss.Entities.Cathegorie;
import com.genilo.plagia_iss.IDao.ICathegorie;

/**
 *
 * @author lappa
 */
public class ICathegorieImpl extends GenericDao<Cathegorie, Long> implements ICathegorie{

    public Cathegorie findByNom(String nom) throws DataAccessException {
        return (Cathegorie)getManager().createQuery("SELECT c FROM Cathegorie c WHERE c.nom = :nom").setParameter("nom", nom).getSingleResult();
  }
   
    
}
