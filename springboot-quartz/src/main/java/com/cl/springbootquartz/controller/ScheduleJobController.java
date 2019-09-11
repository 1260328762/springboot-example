package com.cl.springbootquartz.controller;

import com.cl.springbootquartz.entity.ScheduleJob;
import com.cl.springbootquartz.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleJobController {

    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 创建任务
     *
     * @param scheduleJob
     * @return
     */
    @RequestMapping("/createJob")
    public int createJob(ScheduleJob scheduleJob) {
        return scheduleJobService.insertSelective(scheduleJob);
    }


    /**
     * 暂停任务
     * @param jobId
     * @return
     */
    @RequestMapping("/pauseJob")
    public String pauseJob(Long jobId) {
        scheduleJobService.pauseJob(jobId);
        return "ok";
    }


    /**
     * 恢复任务
     * @param jobId
     * @return
     */
    @RequestMapping("/resumeJob")
    public String resumeJob(Long jobId) {
        scheduleJobService.resumeJob(jobId);
        return "ok";
    }


    /**
     * 立即执行任务
     * @param jobId
     * @return
     */
    @RequestMapping("/triggerJob")
    public String triggerJob(Long jobId){
        scheduleJobService.triggerJob(jobId);
        return "ok";
    }


    /**
     * 更新任务
     * @param scheduleJob
     * @return
     */
    @RequestMapping("/updateJob")
    public String updateJob(ScheduleJob scheduleJob) {
        scheduleJobService.updateJob(scheduleJob);
        return "ok";
    }


    @RequestMapping("/deleteJob")
    public String deleteJob(Long jobId){
        scheduleJobService.deleteJob(jobId);
        return "ok";
    }

}
