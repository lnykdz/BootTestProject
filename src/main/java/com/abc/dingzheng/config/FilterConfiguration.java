package com.abc.dingzheng.config;

import com.abc.dingzheng.boot.simple.FilterTest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new FilterTest());
        bean.addUrlPatterns("/*");
        bean.setOrder(1);
        return bean;
    }
}
