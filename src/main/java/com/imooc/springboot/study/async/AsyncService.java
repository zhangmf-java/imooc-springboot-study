package com.imooc.springboot.study.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步处理服务
 * @author zmf
 * @date 2020/3/24 10:55 下午
 */
@Slf4j
@Service
public class AsyncService {

    //括号中指定线程池的名称
    @Async("getAsyncExecutor")
    public void asyncProcess() throws InterruptedException{
        log.info("async process task ,current thread name -> {}",Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
    }

    @Async("getAsyncExecutor")
    public Future<Integer> asyncProcessHasReturn() throws InterruptedException {
        log.info("async process task (Has Return),current thread name -> {}",Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        return new AsyncResult<>(100);
    }
}
