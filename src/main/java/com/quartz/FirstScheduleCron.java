package com.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class FirstScheduleCron {
    public static void main(String[] args) {
        try {
            //创建一个jobdetail
            JobDetail firstJobDetail = JobBuilder.newJob(FirstJob.class)
                    .withIdentity("firstJob2" + "group1")
                    .build();
            //创建一个cron触发器
            CronExpression cronExpression=new CronExpression("0/5 * * * * ?");
            Trigger fitstTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1")
                    .startNow().withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
            //获取一个调度实例 将前面创的实例并注册
            SchedulerFactory factory = new StdSchedulerFactory();
            Scheduler scheduler = factory.getScheduler();
            scheduler.scheduleJob(firstJobDetail, fitstTrigger);
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
