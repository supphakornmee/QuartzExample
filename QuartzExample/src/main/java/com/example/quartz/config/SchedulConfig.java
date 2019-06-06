package com.example.quartz.config;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.IOException;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import com.example.quartz.run.MyJobOne;
import com.example.quartz.run.MyJobTwo;

@Configuration
public class SchedulConfig {
	
	 @Autowired
	    private ApplicationContext applicationContext;

	
//	@Bean
//	public Scheduler setSchedul() throws SchedulerException {
//		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
//		Scheduler sched = schedFact.getScheduler();
//		try {
//			sched.start();
//			// define the job and tie it to our HelloJob class
//			JobDetail jobOne = newJob(MyJobOne.class).withIdentity("myJob1", "group1") // name "myJob", group "group1"
//					.build();
//
//			Trigger triggerOne = newTrigger().withIdentity("trigger3", "group1")
//					.withSchedule(cronSchedule("0 0/2 * * * ?")).forJob("myJob1", "group1").build();
//
//			// Tell quartz to schedule the job using our trigger
//			sched.scheduleJob(jobOne, triggerOne);
//
//			JobDetail jobTwo = newJob(MyJobTwo.class).withIdentity("myJob2", "group1") // name "myJob", group "group1"
//					.build();
//
//			Trigger triggerTwo = newTrigger().withIdentity("trigger2", "group1")
//					.withSchedule(cronSchedule("0 0/1 * * * ?")).forJob("myJob2", "group1").build();
//
//			// Tell quartz to schedule the job using our trigger
//			sched.scheduleJob(jobTwo, triggerTwo);
//			
//		} catch (SchedulerException e) {
//			throw e;
//		} catch (Exception e) {
//			throw e;
//		}
//		return sched;
//	}
	
	
	@Bean
	public JobDetail jobDetail() {
	    return JobBuilder.newJob().ofType(MyJobOne.class)
	    	.storeDurably()
	    	.withIdentity("myJob1", "group1")
	    	.build();
	}
	
	@Bean
	public Trigger trigger(JobDetail job) {
	    return TriggerBuilder.newTrigger().forJob(job)
	    		.withIdentity("trigger3", "group1")
				.withSchedule(cronSchedule("0 0/1 * * * ?"))
				.build();
	}
	
	 @Bean
	    public SpringBeanJobFactory springBeanJobFactory() {
	        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
	        jobFactory.setApplicationContext(applicationContext);
	        return jobFactory;
	    }

	
	
	@Bean
	public Scheduler scheduler(Trigger trigger, JobDetail job) throws SchedulerException, IOException {
	    StdSchedulerFactory factory = new StdSchedulerFactory();
	    factory.initialize(new ClassPathResource("quartz.properties").getInputStream());
	    Scheduler scheduler = factory.getScheduler();
	    scheduler.setJobFactory(springBeanJobFactory());
	    scheduler.scheduleJob(job, trigger);
	    scheduler.start();
	    return scheduler;
	}
	
	
}
