package com.cl.springbootquartz.quartz;

import com.cl.springbootquartz.entity.ScheduleJob;
import com.cl.springbootquartz.util.JsonUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzJob extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("执行任务...");
        ScheduleJob job = JsonUtils.jsonToPojo((String) context.getMergedJobDataMap().get("params"), ScheduleJob.class);
        System.out.println(job.getBeanName());
        System.out.println(job.getParams());
        String beanName = job.getBeanName();
    }
}
