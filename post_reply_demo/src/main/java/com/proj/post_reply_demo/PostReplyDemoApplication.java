package com.proj.post_reply_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.proj.post_reply_demo.mapper")
public class PostReplyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostReplyDemoApplication.class, args);
    }

}
