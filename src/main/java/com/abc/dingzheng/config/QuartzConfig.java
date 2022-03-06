package com.abc.dingzheng.config;


import com.abc.dingzheng.boot.quartz.DateTimeJob;
import com.abc.dingzheng.boot.quartz.DateTimeJob2;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean(name = "sch")
    public SchedulerFactoryBean scheduler1(Trigger ... triggers){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        Scheduler scheduler = factoryBean.getScheduler();
        // 设置 triggers
        factoryBean.setTriggers(printTimeJobTrigger(), printTimeJobTrigger2());
        // 自动运行
        factoryBean.setAutoStartup(false);
        return factoryBean;
    }

    @Bean
    public JobDetail printTimeJobDetail(){
        return JobBuilder.newJob(DateTimeJob.class)//PrintTimeJob我们的业务类
                .withIdentity("DateTimeJob")//可以给该JobDetail起一个id
                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
                .usingJobData("msg", "Hello DateTimeJob")//关联键值对
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }
    @Bean
    public Trigger printTimeJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail())//关联上述的JobDetail
                .withIdentity("quartzTaskService")//给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }
    @Bean
    public JobDetail printTimeJobDetail2(){
        return JobBuilder.newJob(DateTimeJob2.class)//PrintTimeJob我们的业务类
                .withIdentity("DateTimeJob2")//可以给该JobDetail起一个id
                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
                .usingJobData("msg", "Hello DateTimeJob2")//关联键值对
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }
    @Bean
    public Trigger printTimeJobTrigger2() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail2())//关联上述的JobDetail
                .withIdentity("quartzTaskService2")//给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}