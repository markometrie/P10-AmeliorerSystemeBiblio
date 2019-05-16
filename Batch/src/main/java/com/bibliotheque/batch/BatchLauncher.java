
package com.bibliotheque.batch;

import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BatchLauncher {
    
   @Qualifier("scheduledJob")
    @Autowired
    private Job job;

 
  @Autowired
  private JobLauncher jobLauncher;
 
  public void run() {
      
      try {

	String dateParam = new Date().toString();
        
	JobParameters param = 
	  new JobParametersBuilder().addString("date", dateParam)
                  .addLong("currentTime", new Long(System.currentTimeMillis()))
                  .toJobParameters();

			
	System.out.println(dateParam);
			
	JobExecution execution = jobLauncher.run(job, param);
	System.out.println("Exit Status : " + execution.getStatus());

                       } catch (Exception e) {
	   e.printStackTrace();
    }

  }
      
      /*
    JobParameters parameters = new JobParametersBuilder()
        .addLong("currentTime", new Long(System.currentTimeMillis()))
        .toJobParameters();
    
    try {
      jobLauncher.run(job, parameters);
    } catch (JobExecutionAlreadyRunningException e) {
    } catch (JobRestartException e) {
    } catch (JobInstanceAlreadyCompleteException e) {
    } catch (JobParametersInvalidException e) {
    }
  }

*/
    
}
