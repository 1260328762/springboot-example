package com.cl.springbootquartz.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.cl.springbootquartz.entity.ScheduleJob;
import com.cl.springbootquartz.mapper.ScheduleJobDao;
import com.cl.springbootquartz.util.SchedulerUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleJobService {

    @Autowired
    private ScheduleJobDao scheduleJobDao;

    @Autowired
    private Scheduler scheduler;


    public int insertSelective(ScheduleJob scheduleJob){
        int i = scheduleJobDao.insertSelective(scheduleJob);
        SchedulerUtils.createJob(scheduler, scheduleJob);
        return i;
    }


    public void pauseJob(Long jobId) {
        SchedulerUtils.pauseJob(scheduler, jobId);
    }

    public void resumeJob(Long jobId) {
        SchedulerUtils.resumeJob(scheduler, jobId);
    }

    public void triggerJob(Long jobId) {
        SchedulerUtils.triggerJob(scheduler,jobId);
    }

    public void updateJob(ScheduleJob scheduleJob) {
        SchedulerUtils.updateJob(scheduler, scheduleJob);
    }

    public void deleteJob(Long jobId) {
        SchedulerUtils.deleteJob(scheduler, jobId);
    }
}
