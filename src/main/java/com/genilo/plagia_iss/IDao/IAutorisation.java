/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.genilo.plagia_iss.Entities.Autorisation;

/**
 *
 * @author lappa
 * 
 */
public interface IAutorisation extends IDao<Autorisation, Long>{
    
    public Autorisation findByDroit(String droit) throws DataAccessException;
    
}
