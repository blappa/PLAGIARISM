/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Autorisation;
import com.genilo.plagia_iss.Entities.Departement;
import com.genilo.plagia_iss.Entities.Utilisateur;
import com.genilo.plagia_iss.IDao.IUtilisateur;
import com.genilo.plagia_iss.IService.IServiceUtilisateur;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceUtilisateurImpl implements IServiceUtilisateur {
    
    private IUtilisateur iUtilisateur;
    
    @Override
    public Utilisateur findById(Long id) throws DataAccessException {
        return iUtilisateur.findById(id);
    }
    
    public void create(Utilisateur u, Departement d, Autorisation a) throws DataAccessException {
        u.setDepartement(d);
        u.setAutorisation(a);
        iUtilisateur.create(u);
    }
    
    @Override
    public void delete(Long id) throws DataAccessException {
        Utilisateur u = iUtilisateur.findById(id);
        iUtilisateur.delete(u);
    }

    public void update(Utilisateur u, Departement d, Autorisation a) throws DataAccessException {
        u.setDepartement(d);
        u.setAutorisation(a);
        iUtilisateur.update(u);
    }
    
    @Override
    public List<Utilisateur> findAll() throws DataAccessException {
        return iUtilisateur.findAll();
    }
    
    @Override
    public Utilisateur findByNom(String nom) throws DataAccessException {
        return iUtilisateur.findByNom(nom);
    }
    
    public IUtilisateur getiUtilisateur() {
        return iUtilisateur;
    }
    
    public void setiUtilisateur(IUtilisateur iUtilisateur) {
        this.iUtilisateur = iUtilisateur;
    }
}
