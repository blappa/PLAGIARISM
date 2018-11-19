/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Cathegorie;
import com.genilo.plagia_iss.IDao.ICathegorie;
import com.genilo.plagia_iss.IService.IServiceCathegorie;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceCathegorieImpl implements IServiceCathegorie{
    
    private ICathegorie iCathegorie;

    public void create(Cathegorie c) throws DataAccessException {
        iCathegorie.create(c);
    }

    public void delete(Long id) throws DataAccessException {
       Cathegorie c=iCathegorie.findById(id);
       iCathegorie.delete(c);
    }

    public void update(Cathegorie c) throws DataAccessException {
        iCathegorie.update(c);
    }

    public List<Cathegorie> findAll() throws DataAccessException {
        return iCathegorie.findAll();
    }

    public Cathegorie findByNom(String nom) throws DataAccessException {
        return iCathegorie.findByNom(nom);
    }
    
     public Cathegorie findById(Long id) throws DataAccessException {
       return iCathegorie.findById(id);
    }

    public ICathegorie getiCathegorie() {
        return iCathegorie;
    }

    public void setiCathegorie(ICathegorie iCathegorie) {
        this.iCathegorie = iCathegorie;
    }
    
    
}
