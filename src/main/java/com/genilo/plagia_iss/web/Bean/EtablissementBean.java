/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.web.Bean;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Etablissement;
import com.genilo.plagia_iss.IService.IServiceEtablissement;
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
public class EtablissementBean implements Serializable {

    @ManagedProperty(value = "#{serviceEtablissement}")
    private IServiceEtablissement serviceEtablissement;
    private Etablissement etablissement;
    private List<Etablissement> etablissements;
    private Long etablissementId;

    public EtablissementBean() {
        etablissement = new Etablissement();
    }

    public String saveEtablissement(ActionEvent actionEven) throws DataAccessException {
        serviceEtablissement.create(etablissement);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succés", ""));
        return null;
    }

    public String updateEtablissement(ActionEvent actionEven) throws DataAccessException {
        Etablissement e = serviceEtablissement.findById(etablissement.getId());
        etablissement.setId(e.getId());
        serviceEtablissement.update(etablissement);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "mise à jour avec succées", ""));
        return null;
    }

    public void deleteEtablissement(ActionEvent actionEven) throws DataAccessException {
        serviceEtablissement.delete(etablissement.getId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Etablissement supprimé avec succés", ""));
    }

    public List<Etablissement> getEtablissements() throws DataAccessException {
        etablissements = serviceEtablissement.findAll();
        return etablissements;
    }

    public IServiceEtablissement getServiceEtablissement() {
        return serviceEtablissement;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public Long getEtablissementId() {
        return etablissementId;
    }

    public void setServiceEtablissement(IServiceEtablissement serviceEtablissement) {
        this.serviceEtablissement = serviceEtablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }

    public void setEtablissementId(Long etablissementId) {
        this.etablissementId = etablissementId;
    }
}
