
import com.biblio.BibliothequeServices;
import com.biblio.BibliothequeServicesService;
import com.biblio.InfoPretResponse;


import java.util.List;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;



public class TestBatch {

    
    /*
    Première méthode qui va nous permettre de tester le nombre d'email que contient
    la liste <InfoPret>
    */
    @Test
    public void getListInfoPretTest() {
        
        List<InfoPretResponse> listInfoDocument;
        
        BibliothequeServicesService bibliothequeServicesService= new BibliothequeServicesService();      
        BibliothequeServices port =  bibliothequeServicesService.getBibliothequeServicesPort(); 
        
        listInfoDocument = port.listInfoDocument();
        
        try {
        
        assertTrue("Test la taille de la liste ", listInfoDocument.size() == 1);
        assertTrue("Test si on récupère bien la bonne adresse mail ",listInfoDocument.stream().filter(o -> o.getEmail().equals("matthieu.delomez@gmail.com")).findFirst().isPresent());
        
        assertTrue("Test si nous récupérons le bon livre qui à été emprunté ",listInfoDocument.stream().filter(o -> o.getNomouvrage().equals("1984 - George Orwell")).findFirst().isPresent());
        
        } catch(AssertionError ex) {
            
            fail("Les informations en base ne corresponde pas à la configuration actuelle !");
            
        }
    }
    
    
    
    /*
    Méthode qui va nous permettre de vérifier que la ListInfoPret n'est pas null
    */
    @Test
    public void whenBatchLaunch_GivenException_ThenListInfoPretIsNull () {
        
        List<InfoPretResponse> listInfoDocument;
        
        BibliothequeServicesService bibliothequeServicesService= new BibliothequeServicesService();      
        BibliothequeServices port =  bibliothequeServicesService.getBibliothequeServicesPort(); 
        
        listInfoDocument = port.listInfoDocument();
        

       try { 
       assertNotNull("Verification que l'ecriture n'est pas nulle", listInfoDocument);

       }catch (AssertionError ex) {
           
       fail("Exception Error si la liste est null !!");
         
       }                          


       }
    
    
    
    /*
    Méthode qui va nous permettre de check si la date de fin de pret n'est pas egal à la date du jour
    */
    @Test
    public void whenBatchLaunch_GivenCompareTo_ThenEndDateIsGood() {
        
         List<InfoPretResponse> listInfoDocument;
        
        BibliothequeServicesService bibliothequeServicesService= new BibliothequeServicesService();      
        BibliothequeServices port =  bibliothequeServicesService.getBibliothequeServicesPort(); 
        
        listInfoDocument = port.listInfoDocument();

        
      try {
            
        assertFalse("Retourne une Exception si la date de fin du pret est egal à la date du jour",listInfoDocument.stream().filter((InfoPretResponse o) -> o.getDatefinpret().equals(2019-05-24)).findFirst().isPresent());
        
        
        } catch (AssertionError ex){
            
         fail("La date de fin n'est pas conforme à la date du Jour!");
            
        }

    }
    

    
    
                

                                            

                                            
        
    }
    

