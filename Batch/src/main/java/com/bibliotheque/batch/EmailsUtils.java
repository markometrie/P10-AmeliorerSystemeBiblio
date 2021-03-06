
package com.bibliotheque.batch;


import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * Configuration du batch en utilisant le protocole SMTP.
 *
 * @author Delomez Matthieu
 */
@Component
@Configuration
@EnableBatchProcessing
public class EmailsUtils {


    private static Session session;

    @Value("${mail.smtp.host}")
    private static String host;

    @Value("${mail.smtp.port}")
    private static String port;

    @Value("${mail.noreply.address}")
    private static String addres;

    @Value("${mail.noreply.password}")
    private static String password;


    /**
     * Instantiate and return email session
     *
     * @return
     */

    private static Session getSession() {
        if (session != null) {
            return session;
        }
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
        props.put("mail.smtp.port", "587"); // TLS Port
        props.put("mail.smtp.auth", "true"); // enable authentication
        props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
        props.put("mail.smtp.host", "smtp.gmail.com"); // Configuration du mode Gmail

        // create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {

            // override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("testjavamail61@gmail.com", "Hiopl59%!qs");
            }
        };
        session = Session.getInstance(props, auth);
        return session;
    }

    /**
     * Send mail
     *
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(String toEmail, String subject, String body) {
        Session session = getSession();

        try {
            MimeMessage msg = new MimeMessage(session);
            // set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("testjavamail61@gmail.com", "NoReply-JD"));
            msg.setReplyTo(InternetAddress.parse("matthieu.delomez@gmail.com", false));
            msg.setSentDate(new Date());

            session.setDebug(true);

            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
        } catch (Exception e) {
            session = null;
            e.printStackTrace();
        }
    }
}
    

