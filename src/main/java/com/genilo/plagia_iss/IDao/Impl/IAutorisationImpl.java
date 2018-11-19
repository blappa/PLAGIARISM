/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.genilo.plagia_iss.Entities.Autorisation;
import com.genilo.plagia_iss.IDao.IAutorisation;

/**
 *
 * @author lappa
 */
public class IAutorisationImpl extends GenericDao<Autorisation, Long> implements IAutorisation{

    public Autorisation findByDroit(String droit) throws DataAccessException {
        return (Autorisation)getManager().createQuery("SELECT a FROM Autorisation a WHERE a.droit = :droit")
                .setParameter("droit", droit).getSingleResult();
    }
    
}
