package com.imooc.springboot.study.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zmf
 * @date 2020/3/25 12:06 上午
 */
@Order(2)
@Slf4j
@Component
public class BootApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("This is Boot ApplictionRunner...");
    }
}
