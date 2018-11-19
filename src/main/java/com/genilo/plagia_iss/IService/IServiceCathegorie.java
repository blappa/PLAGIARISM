/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Cathegorie;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceCathegorie {
    
        
    public void create(Cathegorie c) throws DataAccessException;
    
    public void delete(Long id) throws DataAccessException;
    
    public void update(Cathegorie c) throws DataAccessException;
    
    public List<Cathegorie> findAll() throws DataAccessException;
    
    public Cathegorie findById(Long id)throws DataAccessException;
    
    public Cathegorie findByNom(String nom) throws DataAccessException;
    
}
