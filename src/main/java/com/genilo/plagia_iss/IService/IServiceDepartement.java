/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Departement;
import com.genilo.plagia_iss.Entities.Etablissement;
import com.genilo.plagia_iss.Entities.Utilisateur;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceDepartement {

    public void create(Departement d, Etablissement e) throws DataAccessException;

    public void delete(Long id) throws DataAccessException;

    public void update(Departement d, Etablissement e) throws DataAccessException;

    public List<Departement> findAll() throws DataAccessException;
    
     public Departement findById(Long id)throws DataAccessException;
    
    public Departement findByNom(String nom) throws DataAccessException;
    
    public Departement findBySigle(String sigle) throws DataAccessException;
}
