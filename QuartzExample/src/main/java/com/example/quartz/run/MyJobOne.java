package com.example.quartz.run;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;



public class MyJobOne implements Job{

	private static Logger LOGGER = LogManager.getLogger(MyJobOne.class);
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		LOGGER.info("Start MyJobOne.");
		System.out.println("Start MyJobOne.");
	}

}
