/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Plagia;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServicePlagia {
    
    public void create(Plagia p) throws DataAccessException;

    public void delete(Long id) throws DataAccessException;

    public void update(Plagia p) throws DataAccessException;

    public List<Plagia> findAll() throws DataAccessException;
    
    public Plagia findById(Long id)throws DataAccessException;
    
    public Plagia findByAnnee(String d) throws DataAccessException;
    
    public int findNombrePlagiaByYear(String annee, String sigle) throws DataAccessException;
    
    public int findNombrePlagiaByEtablissement(String sigle) throws DataAccessException;
}
