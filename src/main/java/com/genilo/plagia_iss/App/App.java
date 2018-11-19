package com.genilo.plagia_iss.App;

import com.douwe.generic.dao.DataAccessException;
import com.genilo.plagia_iss.Entities.Autorisation;
import com.genilo.plagia_iss.Entities.Departement;
import com.genilo.plagia_iss.Entities.Etablissement;
import com.genilo.plagia_iss.Entities.Utilisateur;
import com.genilo.plagia_iss.IService.IServiceAutorisation;
import com.genilo.plagia_iss.IService.IServiceCathegorie;
import com.genilo.plagia_iss.IService.IServiceDepartement;
import com.genilo.plagia_iss.IService.IServiceEtablissement;
import com.genilo.plagia_iss.IService.IServiceMemoire;
import com.genilo.plagia_iss.IService.IServicePlagia;
import com.genilo.plagia_iss.IService.IServiceUtilisateur;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DataAccessException
    {
//        System.out.println( "Hello World!" );
         ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
          IServiceAutorisation iServiceAutorisation=(IServiceAutorisation)ctx.getBean("serviceAutorisation");
          IServicePlagia iServicePlagia=(IServicePlagia)ctx.getBean("servicePlagia");
          IServiceCathegorie iServiceCathegorie=(IServiceCathegorie)ctx.getBean("serviceCathegorie");
          IServiceDepartement iServiceDepartement=(IServiceDepartement)ctx.getBean("serviceDepartement");
          IServiceEtablissement iServiceEtablissement=(IServiceEtablissement)ctx.getBean("serviceEtablissement");
          IServiceMemoire iServiceMemoire=(IServiceMemoire)ctx.getBean("serviceMemoire");
          IServiceUtilisateur iServiceUtilisateur=(IServiceUtilisateur)ctx.getBean("serviceUtilisateur");
          
          Etablissement e=new Etablissement("Ecole Normal Sup", "ENS");
          iServiceEtablissement.create(e);
          Autorisation a=new Autorisation("CD");
           iServiceAutorisation.create(a);
           Departement dep=new Departement("Informatique","INFO", e);
           iServiceDepartement.create(dep, e);
          Utilisateur u=new Utilisateur("lappa","admin" ,"admin", a, dep);
          iServiceUtilisateur.create(u, dep, a);
 //         iServiceAutorisation.delete(2L);
//          iServiceUtilisateur.delete(2L);
//          Utilisateur u=iServiceUtilisateur.findById(1L);
//          u.setNom("lappa bert");
//          iServiceUtilisateur.update(u);
          
          //nombre de plagia detecter  en 2014 en INFOTEL
           System.out.println("\n nombre de plagia detecté  en 2014 en INFOTEL "+iServicePlagia.findNombrePlagiaByYear("2014", "INFOTEL")+"\n\n");
           //nombre total de plagia detecter à ISS
           System.out.println("\n\n nombre total de plagia detecté à ISS est de "+iServicePlagia.findNombrePlagiaByEtablissement("ISS")+"\n\n");
        
    }
}
