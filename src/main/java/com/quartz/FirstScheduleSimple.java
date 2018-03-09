package com.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class FirstScheduleSimple {
    public static void main(String[] args) {
        try {
            //创建一个jobdetail
            JobDetail firstJobDetail = JobBuilder.newJob(FirstJob.class)
                    .withIdentity("firstJob" + "group1")
                    .build();
            //创建一个simple触发器
            Trigger fitstTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                    .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)).build();
            //获取一个调度实例 将前面创的实例并注册
            SchedulerFactory factory = new StdSchedulerFactory();
            Scheduler scheduler = factory.getScheduler();
            scheduler.scheduleJob(firstJobDetail, fitstTrigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
