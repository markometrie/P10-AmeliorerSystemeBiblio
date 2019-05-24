
package com.bibliotheque.batch;

import com.biblio.BibliothequeServices;
import com.biblio.BibliothequeServicesService;
import com.biblio.InfoPretResponse;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;



@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfiguration {
    

    /*
    Nous configurons notre Scheduler avec Cron qui 
    va nous permettre de lancer le batch
    du lundi au vendredi à 6h30 du matin
    */
//    @Scheduled(fixedDelay = 2*60*1000 )
  @Scheduled(cron = "5 30 6 * * 1-5")
   public void fixedRateSch() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
       
       
      JobParameters param = new JobParametersBuilder()
        .addLong("currentTime", new Long(System.currentTimeMillis()))
        .toJobParameters();
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
                Date now = new Date();
      
                String strDate = sdf.format(now);
      
                System.out.println("Fixed Rate scheduler:: " + strDate);
      

      
      //********************************************************************************************
      
       
                                            // Recuperation du fichier de configuration sous forme de Properties
		Properties emailProps = PropsUtils.getProps("src/email.properties");

		// Configuration EmailUtils
		EmailsUtils.setEmailProperties(emailProps);
		
                                           List<InfoPretResponse> listInfoDocument = null ;
                                           
                
		try {
                    
		 // Recuperation de la liste des clients Dans le web service 
                 
                                             BibliothequeServicesService bibliothequeServicesService= new BibliothequeServicesService();      
                                             BibliothequeServices port =  bibliothequeServicesService.getBibliothequeServicesPort();
                                            
                                             
                                            // Appel Ã  la methode qui va recuperer les mails dont la date de fin de pret est depasse
                                             
                                             listInfoDocument = port.listInfoDocument();
                                                                                                   
                                            
		 } catch (Exception e) {
			e.printStackTrace();
		}
                
		// Envois des email de relance
                
		if (listInfoDocument != null) {
			sendEmail(listInfoDocument);
		}
	                      }
                                           

                                            private static final String SUBJECT = "BOOK NOT RETURNED";

                     

	                     private static void sendEmail(List<InfoPretResponse> listInfoPretResponse) {
                      
                                            for(InfoPretResponse infoPretResponse : listInfoPretResponse) {
                          
                                            /*
                                           Composition du message
                                           return nomOuvrage
                                           return Email
                                           */                     
                                            EmailsUtils.sendEmail(infoPretResponse.getEmail(), SUBJECT, "Bonjour ,  \n vous avez enprunté(e) le livre :" + infoPretResponse.getNomouvrage() + " " +
                                                                                                                                                                 "pendant une période supérieur Ã  4 semaines. \n\n"
                                                                                                                                                              + "Vous êtes donc prié(e) de restituer votre prêt dans votre bibliothèque.\n" +
                                                                                                                                                                  "Cordialement, \n" +
                                                                                                                                                                  "La direction"); 
                                      
                                            }
		
	                      }
                             
      

                            

	@Bean
	public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(jobRepository);
		return launcher;
	}
}
