/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.genilo.plagia_iss.Entities.Plagia;
import com.genilo.plagia_iss.IDao.IPlagia;

/**
 *
 * @author lappa
 */
public class IPlagiaImpl extends GenericDao<Plagia, Long> implements IPlagia{

    public Plagia findByAnnee(String d) throws DataAccessException {
       return (Plagia)getManager().createQuery("SELECT p FROM Plagia p WHERE p.annee = :d")
         .setParameter("d", d).getSingleResult();  
    }
    
    public int findNombrePlagiaByYear(String annee, String sigle) throws DataAccessException {
        return getManager().createQuery("SELECT d FROM Plagia d WHERE  d.annee = :annee and d.departement.sigle = :sigle").
                setParameter("sigle", sigle).setParameter("annee", annee).getResultList().size();
    }

    public int findNombrePlagiaByEtablissement(String sigle) throws DataAccessException {
        return getManager().createQuery("SELECT d FROM Plagia d WHERE d.departement.etablissement.sigle = :sigle").
                setParameter("sigle", sigle).getResultList().size();
    }
    
}
