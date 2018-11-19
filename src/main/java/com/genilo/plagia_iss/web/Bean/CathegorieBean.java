/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.web.Bean;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Cathegorie;
import com.genilo.plagia_iss.IService.IServiceCathegorie;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author kejemto
 */
@ManagedBean
@RequestScoped
public final class CathegorieBean implements Serializable {

    @ManagedProperty(value = "#{serviceCathegorie}")
    private IServiceCathegorie serviceCathegorie;
    private Cathegorie cathegorie;
    private List<Cathegorie> cathegories;
    private SelectItem[] listCathegories;
    private SelectItem[] cathegorieOptions;

    public CathegorieBean() {
        cathegorie = new Cathegorie();
    }

    public String saveCathegorie(ActionEvent actionEven) throws DataAccessException {
        serviceCathegorie.create(cathegorie);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succés", ""));
        return null;
    }

    public String updateCathegorie(ActionEvent actionEven) throws DataAccessException {
        Cathegorie c = serviceCathegorie.findById(cathegorie.getId());
        cathegorie.setId(c.getId());
        serviceCathegorie.update(cathegorie);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return null;
    }

    public void deleteCathegorie(ActionEvent actionEven) throws DataAccessException {
        serviceCathegorie.delete(cathegorie.getId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "la cathegorie a étè supprimé avec succées", ""));
    }

    public IServiceCathegorie getServiceCathegorie() {
        return serviceCathegorie;
    }

    public void setServiceCathegorie(IServiceCathegorie serviceCathegorie) {
        this.serviceCathegorie = serviceCathegorie;
    }

    public Cathegorie getCathegorie() {
        return cathegorie;
    }

    public void setCathegorie(Cathegorie cathegorie) {
        this.cathegorie = cathegorie;
    }

    public List<Cathegorie> getCathegories() {
        try {
            cathegories = serviceCathegorie.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(CathegorieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cathegories;
    }

    public void setCathegories(List<Cathegorie> cathegories) {
        this.cathegories = cathegories;
    }

    public SelectItem[] getListCathegories() {
       
        List<Cathegorie> listcathegories;
        try {
            listcathegories = serviceCathegorie.findAll();
            cathegorieOptions = new SelectItem[listcathegories.size() + 1];
            cathegorieOptions[0] = new SelectItem("Choisir");
            for (int i = 1; i < listcathegories.size() + 1; i++) {
                cathegorieOptions[i] = new SelectItem(listcathegories.get(i - 1).getNom());
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(CathegorieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cathegorieOptions;
    }

    public SelectItem[] getCathegorieOptions() {
        return cathegorieOptions;
    }
    
    
}
