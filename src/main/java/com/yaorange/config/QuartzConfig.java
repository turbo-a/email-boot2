package com.yaorange.config;

import com.yaorange.job.BackupMySQLJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail backupMySQLJobDetail(){
        return JobBuilder.newJob(BackupMySQLJob.class).storeDurably().build();
    }

    @Bean
    public Trigger backupMySQLTrigger(){
        //准备执行计划
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 13 14 * * ? ");
        return TriggerBuilder.newTrigger()
                .forJob(backupMySQLJobDetail())
                .withSchedule(scheduleBuilder)
                .build();
    }

    //省略其他的JobDetail和Trigger配置

}
