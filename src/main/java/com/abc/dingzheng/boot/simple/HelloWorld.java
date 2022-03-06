package com.abc.dingzheng.boot.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @RequestMapping("/hello")
    public String myFirstMethod(){
        return "helloworld";
    }
}
