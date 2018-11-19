/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.web.Bean;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Autorisation;
import com.genilo.plagia_iss.Entities.Departement;
import com.genilo.plagia_iss.Entities.Utilisateur;
import com.genilo.plagia_iss.IService.IServiceAutorisation;
import com.genilo.plagia_iss.IService.IServiceDepartement;
import com.genilo.plagia_iss.IService.IServiceUtilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UtilisateurBean implements Serializable {

    @ManagedProperty(value = "#{serviceUtilisateur}")
    private IServiceUtilisateur serviceUtilisateur;
    @ManagedProperty(value = "#{serviceDepartement}")
    private IServiceDepartement serviceDepartement;
      @ManagedProperty(value = "#{serviceAutorisation}")
    private IServiceAutorisation serviceAutorisation;
    
    private Utilisateur utilisateur;
    private Utilisateur current;
    private List<Utilisateur> utilisateurs;
    private Long departementId;
     private Long utilisateurId;
     private Long autorisationId;

    /**
     * Creates a new instance of MemoireBean
     */
    public UtilisateurBean() {
        utilisateur = new Utilisateur();
        current = new Utilisateur();
    }

    public String login() {
        List<Utilisateur> cc;
        try {
            cc = serviceUtilisateur.findAll();
            utilisateurs = new ArrayList<Utilisateur>();
            for (Utilisateur user : cc) {
                if (user.getLogin().equals(current.getLogin())) {
                    if (user.getPassword().equals(current.getPassword())) {
                        return "admin";
                    }
                }
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(UtilisateurBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String saveUtilisateur(ActionEvent actionEven) throws DataAccessException {
        Departement d = serviceDepartement.findById(departementId);
        Autorisation a=serviceAutorisation.findById(autorisationId);
        serviceUtilisateur.create(utilisateur, d, a);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succés", ""));
        return null;
    }
    
     public String updateUtilisateur(ActionEvent actionEven) throws DataAccessException {
         Utilisateur e = serviceUtilisateur.findById(utilisateur.getId());
        utilisateur.setId(e.getId());
        Departement d = serviceDepartement.findById(departementId);
        Autorisation a=serviceAutorisation.findById(autorisationId);
        serviceUtilisateur.update(utilisateur, d, a);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return null;
    }
     
    public void deleteUtilisateur(ActionEvent actionEven) throws DataAccessException {
        serviceUtilisateur.delete(utilisateur.getId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Utilisateur supprimé avec succés", ""));
    }

    public IServiceUtilisateur getServiceUtilisateur() {
        return serviceUtilisateur;
    }

    public void setServiceUtilisateur(IServiceUtilisateur serviceUtilisateur) {
        this.serviceUtilisateur = serviceUtilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Utilisateur> getUtilisateurs() throws DataAccessException {
        utilisateurs=serviceUtilisateur.findAll();
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Utilisateur getCurrent() {
        return current;
    }

    public void setCurrent(Utilisateur current) {
        this.current = current;
    }

    public IServiceDepartement getServiceDepartement() {
        return serviceDepartement;
    }

    public void setServiceDepartement(IServiceDepartement serviceDepartement) {
        this.serviceDepartement = serviceDepartement;
    }

    public Long getDepartementId() {
        return departementId;
    }

    public void setDepartementId(Long departementId) {
        this.departementId = departementId;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public IServiceAutorisation getServiceAutorisation() {
        return serviceAutorisation;
    }

    public void setServiceAutorisation(IServiceAutorisation serviceAutorisation) {
        this.serviceAutorisation = serviceAutorisation;
    }

    public Long getAutorisationId() {
        return autorisationId;
    }

    public void setAutorisationId(Long autorisationId) {
        this.autorisationId = autorisationId;
    }
    
}
