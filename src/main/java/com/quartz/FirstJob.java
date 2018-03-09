package com.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class FirstJob  implements Job{

    public FirstJob(){

    }
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(jobExecutionContext.getTrigger().getStartTime()+ " triggered. time is:" + (new Date()));
    }
}
