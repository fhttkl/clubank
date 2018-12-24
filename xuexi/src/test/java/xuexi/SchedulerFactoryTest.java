package xuexi;

import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.DateBuilder.*;

public class SchedulerFactoryTest {

	public static void main(String[] args) {
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		try {
			Scheduler sched=schedFact.getScheduler();
			sched.start();
			
			
			JobDetail job = newJob(HelloJob.class)
				      .withIdentity("myJob", "group1")
				      .build();
			
			 Trigger trigger = newTrigger()
			 		  .withIdentity("myTrigger", "group1")
				      .startAt(futureDate(5, IntervalUnit.SECOND))
				      .withSchedule(simpleSchedule()
				          .withIntervalInSeconds(5)
				          .repeatForever())
				      .endAt(dateOf(14, 37, 0))
				      .build();
			 
			 sched.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
