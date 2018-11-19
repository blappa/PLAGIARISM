/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Departement;
import com.genilo.plagia_iss.Entities.Etablissement;
import com.genilo.plagia_iss.IDao.IDepartement;
import com.genilo.plagia_iss.IService.IServiceDepartement;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceDepartementImpl implements IServiceDepartement {

    private IDepartement iDepartement;

  
    public void create(Departement d, Etablissement e) throws DataAccessException {
        d.setEtablissement(e);
        iDepartement.create(d);
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        Departement d = iDepartement.findById(id);
        iDepartement.delete(d);
    }

    @Override
    public void update(Departement d, Etablissement e) throws DataAccessException {
        d.setEtablissement(e);
        iDepartement.update(d);
    }

    @Override
    public List<Departement> findAll() throws DataAccessException {
        return iDepartement.findAll();
    }

    @Override
    public Departement findByNom(String nom) throws DataAccessException {
        return iDepartement.findByNom(nom);
    }

    @Override
    public Departement findBySigle(String sigle) throws DataAccessException {
        return iDepartement.findBySigle(sigle);
    }

    @Override
    public Departement findById(Long id) throws DataAccessException {
        return iDepartement.findById(id);
    }

    public IDepartement getiDepartement() {
        return iDepartement;
    }

    public void setiDepartement(IDepartement iDepartement) {
        this.iDepartement = iDepartement;
    }
}
