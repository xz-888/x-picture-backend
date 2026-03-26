package com.xz.xpicturebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@MapperScan("com.xz.xpicturebackend.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class XPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(XPictureBackendApplication.class, args);
        System.out.println("启动成功");
    }

}
