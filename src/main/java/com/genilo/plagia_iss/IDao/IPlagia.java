/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.genilo.plagia_iss.Entities.Plagia;

/**
 *
 * @author lappa
 */
public interface IPlagia extends IDao<Plagia, Long>{
    
    public Plagia findByAnnee(String d) throws DataAccessException;
    
    public int findNombrePlagiaByYear(String annee, String sigle) throws DataAccessException;
    
    public int findNombrePlagiaByEtablissement(String sigle) throws DataAccessException;
  
}
