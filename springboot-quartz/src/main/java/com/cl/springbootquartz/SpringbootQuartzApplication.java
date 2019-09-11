package com.cl.springbootquartz;

import com.cl.springbootquartz.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("com.cl.springbootquartz.mapper")
public class SpringbootQuartzApplication {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        System.out.println(System.getProperty("user.dir"));
        SpringApplication.run(SpringbootQuartzApplication.class, args);

    }

}
