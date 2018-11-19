/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IService;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Memoire;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceMemoire {
    
    public void create(Memoire m);

    public void delete(Long id);

    public void update(Memoire m);

    public List<Memoire> findAll();
    
    public Memoire findById(Long id);
    
     public Memoire findByDateSoutenance(Date d);

    public Memoire findByNiveau(String niveau);

    public Memoire findByNomFichier(String nom);
    
    public List<Memoire> findListeMemoireByCategorie(String cat);
}
