package com.imooc.springboot.study.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 开机启动
 * @author zmf
 * @date 2020/3/25 12:08 上午
 */
@Order(1)
@Slf4j
@Component
public class BootCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("This is BootCommandLineRunner...");
    }
}
