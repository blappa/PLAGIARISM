/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.genilo.plagia_iss.Entities.Etablissement;
import com.genilo.plagia_iss.IDao.IEtablissement;

/**
 *
 * @author lappa
 */
public class IEtablissementImpl extends GenericDao<Etablissement, Long> implements IEtablissement{

    public Etablissement findByNomEtab(String nom) throws DataAccessException { 
        return (Etablissement)getManager().createQuery("SELECT e FROM Etablissement e WHERE e.nomEtab = :nom")
                .setParameter("nom", nom).getSingleResult();  
    }

    public Etablissement findBySigle(String sigle) throws DataAccessException {
        return (Etablissement)getManager().createQuery("SELECT e FROM Etablissement e WHERE e.sigle = :sigle")
                .setParameter("sigle", sigle).getSingleResult();  
    }
    
}
