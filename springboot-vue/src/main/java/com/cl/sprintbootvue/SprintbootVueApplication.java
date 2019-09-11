package com.cl.sprintbootvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprintbootVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintbootVueApplication.class, args);
        System.out.println(SpringContextUtil.getBean(""));
    }


}
