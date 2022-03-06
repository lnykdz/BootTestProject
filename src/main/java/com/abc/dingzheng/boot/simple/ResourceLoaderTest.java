package com.abc.dingzheng.boot.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Component
public class ResourceLoaderTest {

   @Autowired
   private ResourceLoader  resourceLoader;

   public void getPath(HttpServletRequest request) throws IOException {
       Resource resource = resourceLoader.getResource("classpath:application.properties");
       File file = resource.getFile();
       System.out.println(resource.getURI());
       String path = ResourceUtils.getURL("").getPath();
       System.out.println(path);
       String IP = InetAddress.getLocalHost().getHostAddress();
       System.out.println(IP);
       System.out.println(request.getContextPath());
   }
}
