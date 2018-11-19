/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.web.Bean;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Autorisation;
import com.genilo.plagia_iss.IService.IServiceAutorisation;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author kejemto
 */
@ManagedBean
@RequestScoped
public class AutorisationBean implements Serializable {

    @ManagedProperty(value = "#{serviceAutorisation}")
    private IServiceAutorisation serviceAutorisation;
    
    private Autorisation autorisation;
    private List<Autorisation> autorisations;
    private Long  autorisationId;

    public AutorisationBean() {
        autorisation = new Autorisation();
    }



    public String saveAutorisation(ActionEvent actionEven) throws DataAccessException {
        serviceAutorisation.create(autorisation);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succés", ""));
        return null;
    }
    
     public String updateAutorisation(ActionEvent actionEven) throws DataAccessException {
         Autorisation a = serviceAutorisation.findById(autorisation.getId());
        autorisation.setId(a.getId());
        serviceAutorisation.update(autorisation);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return null;
    }
     
     public void deleteAutorisation(ActionEvent actionEven) throws DataAccessException{
     serviceAutorisation.delete(autorisation.getId());
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cette autorisation a étè supprimé avec succées", ""));
    }

    public IServiceAutorisation getServiceAutorisation() {
        return serviceAutorisation;
    }

    public void setServiceAutorisation(IServiceAutorisation serviceAutorisation) {
        this.serviceAutorisation = serviceAutorisation;
    }

    public Autorisation getAutorisation() {
        return autorisation;
    }

    public void setAutorisation(Autorisation autorisation) {
        this.autorisation = autorisation;
    }

    public List<Autorisation> getAutorisations() throws DataAccessException {
        autorisations=serviceAutorisation.findAll();
        return autorisations;
    }

    public void setAutorisations(List<Autorisation> autorisations) {
        this.autorisations = autorisations;
    }

    public Long getAutorisationId() {
        return autorisationId;
    }

    public void setAutorisationId(Long autorisationId) {
        this.autorisationId = autorisationId;
    }

   
}
