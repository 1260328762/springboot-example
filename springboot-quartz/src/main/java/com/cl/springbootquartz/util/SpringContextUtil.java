package com.cl.springbootquartz.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }


    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }


    public static <T> T getBean(String name, Class<T> beanType) {
        return applicationContext.getBean(name, beanType);
    }
}
