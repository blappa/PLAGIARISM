/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Autorisation;
import com.genilo.plagia_iss.IDao.IAutorisation;
import com.genilo.plagia_iss.IService.IServiceAutorisation;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceAutorisationImpl implements IServiceAutorisation{

    private IAutorisation iAutorisation;
    
    public void create(Autorisation a) throws DataAccessException {
      iAutorisation.create(a);
    }

    public void delete(Long id) throws DataAccessException {
        Autorisation a=iAutorisation.findById(id);
       iAutorisation.delete(a);
    }

    public void update(Autorisation a) throws DataAccessException {
       iAutorisation.update(a);
    }

    public Autorisation findByDroit(String droit) throws DataAccessException {
       return iAutorisation.findByDroit(droit);
    }
    
     public List<Autorisation> findAll() throws DataAccessException {
        return iAutorisation.findAll();
    }
     
      public Autorisation findById(Long id) throws DataAccessException {
       return iAutorisation.findById(id);
    }
     
    public IAutorisation getiAutorisation() {
        return iAutorisation;
    }

    public void setiAutorisation(IAutorisation iAutorisation) {
        this.iAutorisation = iAutorisation;
    }

    
}
