/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Autorisation;
import com.genilo.plagia_iss.Entities.Departement;
import com.genilo.plagia_iss.Entities.Utilisateur;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceUtilisateur {
    
    public void create(Utilisateur u, Departement d, Autorisation a) throws DataAccessException;

    public void delete(Long id) throws DataAccessException;

    public void update(Utilisateur u, Departement d, Autorisation a) throws DataAccessException;

    public List<Utilisateur> findAll() throws DataAccessException;
    
    public Utilisateur findByNom(String nom) throws DataAccessException;
    
    public Utilisateur findById(Long id)throws DataAccessException;
}
