package com.abc.dingzheng;

import com.abc.dingzheng.boot.simple.ApplicationContextTest;
import com.abc.dingzheng.boot.simple.ApplicationContextAwareTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@SpringBootTest
class DingzhengApplicationTests {

    @Autowired
    private ApplicationContextTest ApplicationContextTest;
    @Autowired
    private ApplicationContextAwareTest ApplicationContextAwareTest;
    @Autowired
    private com.abc.dingzheng.boot.simple.ResourceLoaderTest ResourceLoaderTest;
    @Autowired
    private HttpServletRequest request;



    @Test
    void contextLoads() {
    }

    @Test
    void test3(){
        ApplicationContextTest.show();
    }

    @Test
    void test4(){
        ApplicationContextAwareTest.show();
    }
    @Test
    void test6() throws IOException {
        ResourceLoaderTest.getPath(request);
    }

}
