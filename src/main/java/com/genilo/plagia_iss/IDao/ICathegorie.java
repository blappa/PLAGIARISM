/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.genilo.plagia_iss.Entities.Cathegorie;

/**
 *
 * @author lappa
 */
public interface ICathegorie extends IDao<Cathegorie, Long>{
    
    public Cathegorie findByNom(String nom) throws DataAccessException;
    
}
