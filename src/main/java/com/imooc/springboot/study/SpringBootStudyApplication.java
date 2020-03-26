package com.imooc.springboot.study;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 1.@EnableScheduling允许当前应用开启定时任务
 * 2.@EnableAsync开启异步支持
 * @author zmf
 * @date 2020/3/23 4:51 下午
 */
@EnableScheduling
@EnableAsync
@SpringBootApplication
public class SpringBootStudyApplication {
    public static void main(String[] args) {
        //1.通过静态 run方法
        SpringApplication.run(com.imooc.springboot.study.SpringBootStudyApplication.class,args);

        //2.通过API调整应用行为
//        SpringApplication springApplication = new SpringApplication(SpringBootStudyApplication.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
//        springApplication.run(args);

        //3.SpringApplicationBuilder Fluent API,链式调用
//        new SpringApplicationBuilder(SpringBootStudyApplication.class)
//                .bannerMode(Banner.Mode.OFF)
////                .web(WebApplicationType.NONE)
//                .run(args);

    }
}
