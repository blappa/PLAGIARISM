/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.genilo.plagia_iss.Entities.Memoire;
import com.genilo.plagia_iss.IDao.IMemoire;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lappa
 */
public class IMemoireImpl extends GenericDao<Memoire, Long> implements IMemoire{
    

    @Override
    public Memoire findByDateSoutenance(Date d) throws DataAccessException {
       return (Memoire)getManager().createQuery("SELECT m FROM Memoire m WHERE m.dateSoutenance = :date").setParameter("date", d).getSingleResult();  
    }

    @Override
    public Memoire findByNiveau(String niveau) throws DataAccessException {
        return (Memoire)getManager().createQuery("SELECT m FROM Memoire m WHERE m.niveau = :niveau").setParameter("niveau", niveau).getSingleResult();  
    }

    @Override
    public Memoire findByNomFichier(String nom) throws DataAccessException {
        return (Memoire)getManager().createQuery("SELECT m FROM Memoire m WHERE m.nom_fichier = :nom").setParameter("nom", nom).getSingleResult();  
    }

    @Override
    public List<Memoire> findListeMemoireByCategorie(String cat) throws DataAccessException {
        return  getManager().createQuery("SELECT m FROM Memoire m WHERE m.cathegorie.nom = :cat").
                setParameter("cat", cat).getResultList();
    }

    
}
