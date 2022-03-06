package com.abc.dingzheng.boot.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextTest {

    @Autowired
    private ApplicationContext applicationContext;

    public void show(){
        System.out.println(applicationContext.getClass());
    }


}
