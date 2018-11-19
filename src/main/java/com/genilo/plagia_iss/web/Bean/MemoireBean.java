/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.web.Bean;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Cathegorie;
import com.genilo.plagia_iss.Entities.Memoire;
import com.genilo.plagia_iss.Entities.Utilisateur;
import com.genilo.plagia_iss.IService.IServiceCathegorie;
import com.genilo.plagia_iss.IService.IServiceMemoire;
import com.genilo.plagia_iss.IService.IServiceUtilisateur;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityExistsException;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author kejemto
 */
@ManagedBean
@RequestScoped
public class MemoireBean implements Serializable {

    @ManagedProperty(value = "#{serviceMemoire}")
    private IServiceMemoire serviceMemoire;
    @ManagedProperty(value = "#{serviceCathegorie}")
    private IServiceCathegorie serviceCathegorie;
    @ManagedProperty(value = "#{serviceUtilisateur}")
    private IServiceUtilisateur serviceUtilisateur;
    private ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    private String path = servletContext.getRealPath("") + File.separator + "memoires";
    private File file;
    private Memoire memoire = new Memoire();
    private List<Memoire> memoires;
    private StreamedContent fileContent;
    private List<Memoire> filteredMemoire;
    List<Memoire> selctmemoires;
    private static String nomMemoire;
    private Long utilisateurId;
    private Long cathegorieId;

    /**
     * Creates a new instance of MemoireBean
     */
    public MemoireBean() {
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException, DataAccessException {
        // Do what you want with the file 
//        Cathegorie c=serviceCathegorie.findById(cathegorieId);
//        Utilisateur u=serviceUtilisateur.findById(utilisateurId);
//        memoire.setCathegorie(c);
//        memoire.setUtilisateur(u);
        memoire.setNom_fichier(event.getFile().getFileName());
        nomMemoire = event.getFile().getFileName();
        try {
            serviceMemoire.create(memoire);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "le fichier " + event.getFile().getFileName() + " a étè bien chargé"));
            String filePath = path + File.separator + event.getFile().getFileName();
            file = new File(filePath);
            copyFile(event.getFile().getInputstream());
        } catch (EntityExistsException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "le fichier " + event.getFile().getFileName() + " existe deja."));
        }
    }

    public void copyFile(InputStream in) {
        try {
            // write the inputStream to a FileOutputStream

            OutputStream out = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String saveMemoire(ActionEvent actionEven) throws DataAccessException {
        if (nomMemoire != null) {
            Memoire m = serviceMemoire.findByNomFichier(nomMemoire);
            memoire.setNom_fichier(nomMemoire);
            Utilisateur e = serviceUtilisateur.findById(utilisateurId);
            memoire.setUtilisateur(e);
            Cathegorie d = serviceCathegorie.findById(cathegorieId);
            memoire.setCathegorie(d);
            memoire.setId(m.getId());
            serviceMemoire.update(memoire);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succés", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veillez charger d'abord le fichier memoire", ""));
        }
        return null;
    }

    public void deleteMemoire(ActionEvent actionEven) throws DataAccessException {
        if (memoire != null) {
            serviceMemoire.delete(memoire.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ce memoire a étè supprimé avec succés", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SVP veillez choisir le fichier à supprimer dans la liste", ""));
            memoire = new Memoire();
        }
    }

    public List<Memoire> rechercher(ActionEvent actionEven) throws DataAccessException {
        selctmemoires = new ArrayList<Memoire>();
        int i = 0;
        Cathegorie c = serviceCathegorie.findById(cathegorieId);
        memoires = serviceMemoire.findAll();
        for (Memoire memoire1 : memoires) {
            if (memoire1.getCathegorie().getId().equals(cathegorieId)) {
                selctmemoires.add(memoire1);
                i = 1;
            }
        }
        if (i != 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Liste de memoire appartement à la categorie " + c.getNom(), ""));
            return selctmemoires;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aucun memoire appartement à la cathégorie " + c.getNom(), ""));
            return null;
        }
    }

    public IServiceMemoire getServiceMemoire() {
        return serviceMemoire;
    }

    public void setServiceMemoire(IServiceMemoire serviceMemoire) {
        this.serviceMemoire = serviceMemoire;
    }

    public Memoire getMemoire() {
        return memoire;
    }

    public void setMemoire(Memoire memoire) {
        this.memoire = memoire;
    }

    public List<Memoire> getMemoires() {
        memoires = new ArrayList<Memoire>();
        memoires.addAll(serviceMemoire.findAll());
        return memoires;
    }

    public void setMemoires(List<Memoire> memoires) {
        this.memoires = memoires;
    }

    public StreamedContent getFileContent() {
        if (memoire != null) {
            InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/memoires/" + memoire.getNom_fichier());
            fileContent = new DefaultStreamedContent(stream, "pdf", memoire.getNom_fichier());
            return fileContent;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SVP veillez choisir un fichier dans la liste", ""));
            memoire = new Memoire();
        }
        return null;
    }

    public void setFileContent(StreamedContent fileContent) {
        this.fileContent = fileContent;
    }

    public List<Memoire> getFilteredMemoire() {
        return filteredMemoire;
    }

    public void setFilteredMemoire(List<Memoire> filteredMemoire) {
        this.filteredMemoire = filteredMemoire;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public IServiceCathegorie getServiceCathegorie() {
        return serviceCathegorie;
    }

    public void setServiceCathegorie(IServiceCathegorie serviceCathegorie) {
        this.serviceCathegorie = serviceCathegorie;
    }

    public IServiceUtilisateur getServiceUtilisateur() {
        return serviceUtilisateur;
    }

    public void setServiceUtilisateur(IServiceUtilisateur serviceUtilisateur) {
        this.serviceUtilisateur = serviceUtilisateur;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Long getCathegorieId() {
        return cathegorieId;
    }

    public void setCathegorieId(Long cathegorieId) {
        this.cathegorieId = cathegorieId;
    }

    public static String getNomMemoire() {
        return nomMemoire;
    }

    public static void setNomMemoire(String nomMemoire) {
        MemoireBean.nomMemoire = nomMemoire;
    }

    public void setSelctmemoires(List<Memoire> selctmemoires) {
        this.selctmemoires = selctmemoires;
    }
}
