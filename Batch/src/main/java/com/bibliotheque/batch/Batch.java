
package com.bibliotheque.batch;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *  Batch envoi d'email automatisÃ© pour les clients dont
 * la date de fin de prÃªt est expirÃ©e.
 * 
 *
 * @author Delomez Matthieu
 */


                                           
                                           @SpringBootApplication
                                           @EnableScheduling
                                           public class Batch {
                                                   
                                           /**
                                           *
                                           * @param args
                                           * @throws java.io.IOException
                                           */
                                           public static void main(String[] args) throws IOException {
                                               
                                           SpringApplication.run(Batch.class, args);
                                            
                                           
                                            }
                                            }
    
