/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Memoire;
import com.genilo.plagia_iss.IDao.IMemoire;
import com.genilo.plagia_iss.IService.IServiceMemoire;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceMemoireImpl implements IServiceMemoire{
    
    private IMemoire iMemoire;

    @Override
    public void create(Memoire m){
        try {
            iMemoire.create(m);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMemoireImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Long id){
        Memoire m;
        try {
            m = iMemoire.findById(id);
            iMemoire.delete(m);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMemoireImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public void update(Memoire m){
        try {
            iMemoire.update(m);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMemoireImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Memoire> findAll(){
        try {
            return iMemoire.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMemoireImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Memoire findById(Long id){
        try {
            return iMemoire.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMemoireImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Memoire findByDateSoutenance(Date d){
        try {
            return iMemoire.findByDateSoutenance(d);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMemoireImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Memoire findByNiveau(String niveau){
        try {
            return iMemoire.findByNiveau(niveau);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMemoireImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Memoire findByNomFichier(String nom){
        try {
            return iMemoire.findByNomFichier(nom);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMemoireImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Memoire> findListeMemoireByCategorie(String cat) {
        try {
            return iMemoire.findListeMemoireByCategorie(cat);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMemoireImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public IMemoire getiMemoire() {
        return iMemoire;
    }

    public void setiMemoire(IMemoire iMemoire) {
        this.iMemoire = iMemoire;
    }

    
    
}
