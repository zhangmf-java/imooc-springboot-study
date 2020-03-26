package com.imooc.springboot.study.service;

import com.alibaba.fastjson.JSON;
import com.imooc.springboot.service.ISplitService;
import com.imooc.springboot.study.config.SpringBootConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zmf
 * @date 2020/3/26 12:02 下午
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SplitServiceTest {

    @Autowired
    private ISplitService splitService;

    @Autowired
    private SpringBootConfig springBootConfig;

    @Test
    public void testSplitVersion(){

        log.info("split version: {}", JSON.toJSONString(splitService.split(springBootConfig.getVersion())));

    }
}
