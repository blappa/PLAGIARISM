/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.IDao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.genilo.plagia_iss.Entities.Memoire;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IMemoire extends IDao<Memoire, Long> {

    public Memoire findByDateSoutenance(Date d) throws DataAccessException;

    public Memoire findByNiveau(String niveau) throws DataAccessException;

    public Memoire findByNomFichier(String nom) throws DataAccessException;
    
    public List<Memoire> findListeMemoireByCategorie(String cat) throws DataAccessException;
}
