package com.imooc.springboot.study.service;

import com.imooc.springboot.study.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 异步服务功能测试
 * @author zmf
 * @date 2020/3/24 11:43 下午
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsyncProcess() throws InterruptedException {
        asyncService.asyncProcess();
        log.info("come in testAsyncProcess...");
    }

    @Test
    public void testAsyncProcessHasReturn() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Future<Integer> future = asyncService.asyncProcessHasReturn();
        log.info("get async tack value :{}",future.get());
        log.info("time elapse for async tack :{}ms",System.currentTimeMillis() - start);
    }

}
