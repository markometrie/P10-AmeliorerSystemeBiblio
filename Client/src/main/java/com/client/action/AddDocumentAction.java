
package com.client.action;

import com.biblio.BibliothequeServices;
import com.biblio.BibliothequeServicesService;
import com.biblio.DocumentResponse;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Ben Gourion
 */
public class AddDocumentAction extends ActionSupport {
    
      BibliothequeServicesService bibliothequeServicesService= new BibliothequeServicesService();
      BibliothequeServices port =  bibliothequeServicesService.getBibliothequeServicesPort();


       //=========Attributs=============
    
       private int refOuvrage;
       private int refBibliotheque;
       
       private String nomBibliotheque;
       
       private String nomOuvrage;
       
       private String categorie;
       
       private String rayon;
       
       private String quantiteTotal;
       
       //=========Elements Struts=============
       
       
       
       //=========Getters & Setters=============

    /**
     *
     * @return
     */

    public int getRefOuvrage() {
        return refOuvrage;
    }

    /**
     *
     * @param refOuvrage
     */
    public void setRefOuvrage(int refOuvrage) {
        this.refOuvrage = refOuvrage;
    }

    /**
     *
     * @return
     */
    public int getRefBibliotheque() {
        return refBibliotheque;
    }

    /**
     *
     * @param refBibliotheque
     */
    public void setRefBibliotheque(int refBibliotheque) {
        this.refBibliotheque = refBibliotheque;
    }

    /**
     *
     * @return
     */
    public String getNomOuvrage() {
        return nomOuvrage;
    }

    /**
     *
     * @param nomOuvrage
     */
    public void setNomOuvrage(String nomOuvrage) {
        this.nomOuvrage = nomOuvrage;
    }

    /**
     *
     * @return
     */
    public String getQuantiteTotal() {
        return quantiteTotal;
    }

    /**
     *
     * @param quantiteTotal
     */
    public void setQuantiteTotal(String quantiteTotal) {
        this.quantiteTotal = quantiteTotal;
    }
    

    public String getNomBibliotheque() {
        return nomBibliotheque;
    }

    public void setNomBibliotheque(String nomBibliotheque) {
        this.nomBibliotheque = nomBibliotheque;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }
    
    
    
    
    


    
    //=========Methodes=============
    
    
    /*
    Méthode pour ajouter un nouveau document.
    return vResult
    */

    /**
     *
     * @return
     */

    public String doAddDocument() {
        
        String vResult = ActionSupport.INPUT;  
        
        DocumentResponse documentResponse = new DocumentResponse();
        
        documentResponse.setRefbibliotheque(refBibliotheque);
        documentResponse.setNombibliotheque(nomBibliotheque);
        documentResponse.setNomouvrage(nomOuvrage);
        documentResponse.setCategorie(categorie);
        documentResponse.setRayon(rayon);
        documentResponse.setQuantitetotal(quantiteTotal);
        
        
        try {
            
        if(!StringUtils.isAllEmpty(nomBibliotheque ,nomOuvrage, quantiteTotal)) {
                   
            
        
        port.addDocument( refBibliotheque, nomBibliotheque, nomOuvrage, categorie, rayon,quantiteTotal);
        
        vResult = ActionSupport.SUCCESS;
        
        }
        
        } catch (Exception pe) {
        
        this.addActionError("Veuillez remplir tout les champs correctement");
        
        }
        
        return vResult;
        
    }


    
    }
