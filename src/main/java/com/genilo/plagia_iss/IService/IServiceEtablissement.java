/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Etablissement;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceEtablissement {
    
    public void create(Etablissement e) throws DataAccessException;

    public void delete(Long id) throws DataAccessException;

    public void update(Etablissement e) throws DataAccessException;

    public List<Etablissement> findAll() throws DataAccessException;
    
    public Etablissement findById(Long id)throws DataAccessException;
    
    public Etablissement findByNomEtab(String nom) throws DataAccessException;
    
    public Etablissement findBySigle(String sigle)throws DataAccessException;
}
