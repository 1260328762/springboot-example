package com.cl.springbootquartz.mapper;

import com.cl.springbootquartz.entity.ScheduleJob;
import org.springframework.stereotype.Component;

@Component
public interface ScheduleJobDao {
    int insertSelective(ScheduleJob scheduleJob);
}
