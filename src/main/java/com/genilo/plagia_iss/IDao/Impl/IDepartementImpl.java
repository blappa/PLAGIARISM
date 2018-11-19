/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.genilo.plagia_iss.Entities.Departement;
import com.genilo.plagia_iss.IDao.IDepartement;
import java.util.Date;

/**
 *
 * @author lappa
 */
public class IDepartementImpl extends GenericDao<Departement, Long> implements IDepartement{

    public Departement findByNom(String nom) throws DataAccessException {
         return (Departement)getManager().createQuery("SELECT d FROM Departement d WHERE d.nom = :nom")
         .setParameter("nom", nom).getSingleResult();  
    }

    public Departement findBySigle(String sigle) throws DataAccessException {
        return (Departement)getManager().createQuery("SELECT d FROM Departement d WHERE d.sigle = :sigle")
                .setParameter("sigle", sigle).getSingleResult();  
    }

}
