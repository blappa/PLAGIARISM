/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Plagia;
import com.genilo.plagia_iss.IDao.IPlagia;
import com.genilo.plagia_iss.IService.IServicePlagia;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServicePlagiaImpl implements IServicePlagia{

    private IPlagia iPlagia;
    
    public void create(Plagia p) throws DataAccessException {
       iPlagia.create(p);
    }

    public void delete(Long id) throws DataAccessException {
        Plagia p =iPlagia.findById(id);
        iPlagia.delete(p);
    }

    public void update(Plagia p) throws DataAccessException {
        iPlagia.update(p);
    }

    public List<Plagia> findAll() throws DataAccessException {
        return iPlagia.findAll();
    }

    public Plagia findById(Long id) throws DataAccessException {
        return iPlagia.findById(id);
    }

    public Plagia findByAnnee(String d) throws DataAccessException {
       return iPlagia.findByAnnee(d);
    }

    public int findNombrePlagiaByYear(String annee, String sigle) throws DataAccessException {
        return iPlagia.findNombrePlagiaByYear(annee, sigle);
    }

    public int findNombrePlagiaByEtablissement(String sigle) throws DataAccessException {
        return iPlagia.findNombrePlagiaByEtablissement(sigle);
    }

    public IPlagia getiPlagia() {
        return iPlagia;
    }

    public void setiPlagia(IPlagia iPlagia) {
        this.iPlagia = iPlagia;
    }
    
}
