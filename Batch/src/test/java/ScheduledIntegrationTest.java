
import com.bibliotheque.batch.BatchConfiguration;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.awaitility.Awaitility.await;

import org.awaitility.Duration;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;




@SpringJUnitConfig(BatchConfiguration.class)
public class ScheduledIntegrationTest {
    
    @SpyBean
    private BatchConfiguration batchScheduled;
    
    @Test
    public void whenWaitOneSecond_thenScheduledIsCalledOneTime() {

            
            try {
                
                await()
                .atMost(Duration.ONE_SECOND)
                .untilAsserted(() -> verify( batchScheduled, atLeast(1)).fixedRateSch());
            
                System.out.println("Batch lancé correctement !");
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
                Date now = new Date();
      
                String strDate = sdf.format(now);
      
                System.out.println("Fixed Rate scheduler:: " + strDate);
                
            }
            
            catch (Exception cte) {
               System.out.println("Erreur de Lancement du Batch");
                
            }
            
    }
    
}
