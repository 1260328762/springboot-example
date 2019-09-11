package com.cl.springbootquartz.quartz.task;

import org.springframework.stereotype.Component;

@Component("backUp")
public class BackUpDB {

    public void backup(String dbName){
        System.out.println("备份数据库" +dbName);
    }
}
