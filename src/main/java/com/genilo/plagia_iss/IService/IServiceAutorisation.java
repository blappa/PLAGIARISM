/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Autorisation;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceAutorisation {
    
    public void create(Autorisation a) throws DataAccessException;
    
    public void delete(Long id) throws DataAccessException;
    
    public void update(Autorisation a) throws DataAccessException;
    
    public List<Autorisation> findAll() throws DataAccessException;
    
    public Autorisation findById(Long id)throws DataAccessException;
    
    public Autorisation findByDroit(String droit) throws DataAccessException;
}
