package com.abc.dingzheng.boot.quartz;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class QuartzTest {

    @Autowired
    @Qualifier("sch")
    private Scheduler scheduler;

    public void testQuartzPause() throws SchedulerException {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        JobKey key1 = new JobKey("DateTimeJob");
        JobKey key2 = new JobKey("DateTimeJob2");
        scheduler.pauseJob(key1);
    }
}
