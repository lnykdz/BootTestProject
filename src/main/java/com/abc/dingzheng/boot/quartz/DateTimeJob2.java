package com.abc.dingzheng.boot.quartz;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeJob2 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取JobDetail中关联的数据
        String msg = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("msg");
        System.out.println("test2 time :" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "---" + msg);
    }
}