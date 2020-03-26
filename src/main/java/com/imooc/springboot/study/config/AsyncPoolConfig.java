package com.imooc.springboot.study.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zmf
 * @date 2020/3/24 11:02 下午
 */
@Slf4j
@Configuration
public class AsyncPoolConfig implements AsyncConfigurer {
    @Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        //核心线程数
        executor.setCorePoolSize(10);
        //最大线程数
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(20);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("ImoocAsync_");

        //线程执行完成后关闭线程  默认为false
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //等待60秒后关闭
        executor.setAwaitTerminationSeconds(60);

        //拒绝策略
        //DiscardPolicy不作为，最大线程满了，不接受新的请求
        //DiscardOldestPolicy 抛弃队列中老的任务，接受新的请求
        //AbortPolicy 满了就抛异常
        //CallerRunsPolicy 在任务被拒绝添加后，会调用当前线程池的所在的线程去执行被拒绝的任务 可能会阻塞主线程
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    /**
     * 定义异步任务异步处理类
     * 1.没有返回值的异步调用  AsyncUncaughtExceptionHandler会捕获异常  原程序继续执行
     * 2.有返回值的异步调用    由客户端自己处理
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

    class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{

        /**
         * @param throwable 异步任务抛出的异常对象
         * @param method 异常处理方法
         * @param objects 异常处理方法需要传进来的参数
         */
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("AcyncError:{},method: {},object:{}",
                    throwable.getMessage(),method.getName(), JSON.toJSONString(objects));
            throwable.printStackTrace();

            //TODO 发送邮件或者发送短信
        }
    }
}
