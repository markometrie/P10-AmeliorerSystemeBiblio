
import com.bibliotheque.batch.EmailsUtils;
import static com.oracle.jrockit.jfr.ContentType.Address;
import com.sun.mail.smtp.SMTPMessage;
import java.time.LocalDate;
import java.time.Month;
import java.util.Properties;
import java.util.stream.Stream;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;
import org.jvnet.mock_javamail.Mailbox;
import org.subethamail.wiser.Wiser;




public class BatchTest {
    
   
    

    /*
    Wiser inMemorySmtpServer = new Wiser();
    SmtpConfig smtpConfig = SmtpConfig.of("localhost", 5555);
    
    EmailsUtils emailsUtils = new EmailsUtils(smtpConfig); //SUT

    @Before
    public void beforeTest(){
        inMemorySmtpServer.setPort(smtpConfig.getPort());
        inMemorySmtpServer.start();
    }

    @After
    public void afterTest(){
        inMemorySmtpServer.stop();
    }

    @Test
    public void testSiPretInferieur1MoisNoEmail(){
        
      //  Stream<String> nobody = Stream.empty();
        LocalDate dateDebut = LocalDate.of(2019, Month.MAY, 11);
        LocalDate dateFin = LocalDate.of(2019, Month.JUNE, 9);

    //    emailsUtils.sendEmail(toEmail, subject, body);

        assertThat(inMemorySmtpServer.getMessages()).isEmpty();
    }
    

    @Test
    public void testSiPretSuperieur1Mois(){
        
        Stream<String> pretExpire = Stream.of("matthieu.delomez@gmail.com");
        
        LocalDate dateDebut = LocalDate.of(2019, Month.MAY, 11);
        LocalDate dateFin = LocalDate.of(2019, Month.JUNE, 12);

        emailsUtils.sendEmail(toEmail, subject, body);

        assertThat(inMemorySmtpServer.getMessages())
                
            .extracting("envelopeSender", "envelopeReceiver", "mimeMessage.content")
            .containsOnly(
                    
                    tuple("testjavamail61@gmail.com", "matthieu.delomez@gmail.com", "Bonjour, la direction vous informe que le délais de prêt à été dépassé!" + System.lineSeparator())
                    
                    
                    
            );
    }*/
}

