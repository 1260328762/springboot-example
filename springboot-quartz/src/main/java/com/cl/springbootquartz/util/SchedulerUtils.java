package com.cl.springbootquartz.util;

import com.cl.springbootquartz.entity.ScheduleJob;
import com.cl.springbootquartz.quartz.QuartzJob;
import org.quartz.*;

public class SchedulerUtils {


    /**
     * 创建Job
     * @param scheduler
     * @param scheduleJob
     */
    public static void createJob(Scheduler scheduler, ScheduleJob scheduleJob) {
        try {
            Long id = scheduleJob.getJobId();

            //创建job对象
            JobDetail job = JobBuilder.newJob(QuartzJob.class).withIdentity("JOB_" + id).build();

            //创建触发器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("TRIGGER_" + id)
                    .withSchedule(cronScheduleBuilder)
                    .build();

            //存放参数
            job.getJobDataMap().put("params", JsonUtils.objectToJson(scheduleJob));

            scheduler.scheduleJob(job, trigger);
            pauseJob(scheduler,scheduleJob.getJobId());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }


    /**
     * 暂停任务
     * @param scheduler
     * @param jobId
     */
    public static void pauseJob(Scheduler scheduler, Long jobId){
        try {
            scheduler.pauseJob(JobKey.jobKey("JOB_" + jobId));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 恢复任务
     * @param scheduler
     * @param jobId
     */
    public static void resumeJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.resumeJob(JobKey.jobKey("JOB_" + jobId));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 立即执行一次
     * @param jobId
     */
    public static void triggerJob(Scheduler scheduler,Long jobId) {
        try {
            scheduler.triggerJob(JobKey.jobKey("JOB_" + jobId));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新任务
     * @param scheduler
     * @param scheduleJob
     */
    public static void updateJob(Scheduler scheduler,ScheduleJob scheduleJob){

        try {
            //获取新的cron表达式
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            //获取此任务的TriggerKey
            TriggerKey triggerKey = TriggerKey.triggerKey("TRIGGER_" + scheduleJob.getJobId());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            //在此Trigger的基础上面重新构建cron
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                    .withSchedule(cronScheduleBuilder)
                    .build();

            //更新trigger
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 删除任务
     * @param scheduler
     * @param jobId
     */
    public static void deleteJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.deleteJob(JobKey.jobKey("JOB_" + jobId));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
