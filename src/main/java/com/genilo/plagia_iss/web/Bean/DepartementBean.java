/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.web.Bean;
import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Departement;
import com.genilo.plagia_iss.Entities.Etablissement;
import com.genilo.plagia_iss.IService.IServiceDepartement;
import com.genilo.plagia_iss.IService.IServiceEtablissement;
import com.genilo.plagia_iss.IService.IServiceUtilisateur;
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
public class DepartementBean implements Serializable{

    @ManagedProperty(value = "#{serviceDepartement}")
    private IServiceDepartement serviceDepartement;
    @ManagedProperty(value = "#{serviceUtilisateur}")
    private IServiceUtilisateur serviceUtilisateur;
    @ManagedProperty(value = "#{serviceEtablissement}")
    private IServiceEtablissement serviceEtablissement;
    
    private Departement departement;
    private List<Departement> departements;
    private Long etablissementId;
    private Long departementId;

   
    public DepartementBean() {
        departement = new Departement();
    }
    
    public String saveDepartement(ActionEvent actionEven) throws DataAccessException{
           Etablissement e=serviceEtablissement.findById(etablissementId);
           serviceDepartement.create(departement, e);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"enregistrement avec succés", ""));
           return null;
    }
    
     public String updateDepartement(ActionEvent actionEven) throws DataAccessException{
           Etablissement e=serviceEtablissement.findById(etablissementId);
           Departement d=serviceDepartement.findById(departement.getId());
           departement.setId(d.getId());
           serviceDepartement.update(departement, e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"mise à jour avec succées", ""));  
           return null;
    }
     
    public void deleteDepartement(ActionEvent actionEven) throws DataAccessException{
    serviceDepartement.delete(departement.getId());
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Departement supprimé avec succés", ""));
    }

    public List<Departement> getDepartements() throws DataAccessException {
        departements=serviceDepartement.findAll();
        return departements;
    }
    
    public IServiceDepartement getServiceDepartement() {
        return serviceDepartement;
    }

    public IServiceUtilisateur getServiceUtilisateur() {
        return serviceUtilisateur;
    }

    public IServiceEtablissement getServiceEtablissement() {
        return serviceEtablissement;
    }

    public Departement getDepartement() {
        return departement;
    }
    
    public Long getEtablissementId() {
        return etablissementId;
    }

    public Long getDepartementId() {
        return departementId;
    }

    public void setServiceDepartement(IServiceDepartement serviceDepartement) {
        this.serviceDepartement = serviceDepartement;
    }

    public void setServiceUtilisateur(IServiceUtilisateur serviceUtilisateur) {
        this.serviceUtilisateur = serviceUtilisateur;
    }

    public void setServiceEtablissement(IServiceEtablissement serviceEtablissement) {
        this.serviceEtablissement = serviceEtablissement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }

    public void setEtablissementId(Long etablissementId) {
        this.etablissementId = etablissementId;
    }

    public void setDepartementId(Long departementId) {
        this.departementId = departementId;
    }
    
}
