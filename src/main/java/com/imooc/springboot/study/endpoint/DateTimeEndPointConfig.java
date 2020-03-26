package com.imooc.springboot.study.endpoint;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义端点配置类
 * @author zmf
 * @date 2020/3/25 11:23 上午
 */
@Configuration
public class DateTimeEndPointConfig {

    @Bean
    @ConditionalOnMissingBean //当缺少这个bean的时候才会注入该bean
    public DateTimeEndpoint dateTimeEndpoint(){
        return new DateTimeEndpoint();
    }

}
