/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.genilo.plagia_iss.Entities.Etablissement;

/**
 *
 * @author lappa
 */
public interface IEtablissement extends IDao<Etablissement, Long>{
    
      public Etablissement findByNomEtab(String nom) throws DataAccessException;
    
      public Etablissement findBySigle(String sigle)throws DataAccessException;
      
}
