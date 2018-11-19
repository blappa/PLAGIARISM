/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Etablissement;
import com.genilo.plagia_iss.IDao.IEtablissement;
import com.genilo.plagia_iss.IService.IServiceEtablissement;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceEtablissementImpl implements IServiceEtablissement{

    private IEtablissement iEtablissement;
    
    public Etablissement findByNomEtab(String nom) throws DataAccessException {
       return iEtablissement.findByNomEtab(nom);
    }

    public Etablissement findBySigle(String sigle) throws DataAccessException {
        return iEtablissement.findBySigle(sigle);
    }

    public Etablissement findById(Long id) throws DataAccessException {
       return iEtablissement.findById(id);
    }

    public List<Etablissement> findAll() throws DataAccessException {
        return iEtablissement.findAll();
    }

    public void create(Etablissement e) throws DataAccessException {
        iEtablissement.create(e);
    }

    public void delete(Long id) throws DataAccessException {
        Etablissement e=iEtablissement.findById(id);
        iEtablissement.delete(e);
    }

    public void update(Etablissement e) throws DataAccessException {
        iEtablissement.update(e);
    }
    
     public IEtablissement getiEtablissement() {
        return iEtablissement;
    }

    public void setiEtablissement(IEtablissement iEtablissement) {
        this.iEtablissement = iEtablissement;
    }
}
