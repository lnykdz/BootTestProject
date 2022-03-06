package com.abc.dingzheng.boot.simple;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextAwareTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void show(){
        System.out.println(applicationContext.getClass());
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }
}
