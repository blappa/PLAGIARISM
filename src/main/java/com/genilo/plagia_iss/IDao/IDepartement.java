/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.genilo.plagia_iss.Entities.Departement;

/**
 *
 * @author lappa
 */
public interface IDepartement  extends IDao<Departement, Long>{
    
    public Departement findByNom(String nom) throws DataAccessException;
    
    public Departement findBySigle(String sigle) throws DataAccessException;
   
    
}
