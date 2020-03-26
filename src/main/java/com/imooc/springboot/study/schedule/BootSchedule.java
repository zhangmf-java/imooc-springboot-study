package com.imooc.springboot.study.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zmf
 * @date 2020/3/24 10:45 下午
 */
@Slf4j
//@Component
public class BootSchedule {

    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 上一次开始执行时间点后3000毫秒再次执行
     */
    @Scheduled(fixedRate = 3000)
    public void schedule01(){
        log.info("schedule01 -> {}",LocalDateTime.now().format(fmt));
    }

    /**
     * 上一次执行完成时间点后3000毫秒再次执行
     */
    @Scheduled(fixedDelay = 3000)
    public void schedule02(){
        log.info("schedule02 -> {}",LocalDateTime.now().format(fmt));
    }

    /**
     * 第一次延迟2000毫秒执行，之后按照3s执行一次
     */
    @Scheduled(initialDelay = 2000,fixedRate = 3000)
    public void schedule03(){
        log.info("schedule03 -> {}",LocalDateTime.now().format(fmt));
    }

    /**
     * cron 表达式 3s执行一次
     */
    @Scheduled(cron = "*/3 * * * * ?")
    public void schedule04(){
        log.info("schedule04 -> {}",LocalDateTime.now().format(fmt));
    }

}
