package com.yaorange.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class SampleJob extends QuartzJobBean {
    Logger logger = LoggerFactory.getLogger(QuartzJobBean.class);

    @Override
    protected void executeInternal(JobExecutionContext context)throws JobExecutionException {
        //自定义定义任务的代码
        //.............
        logger.info("quartz task "+new Date());
    }

}
