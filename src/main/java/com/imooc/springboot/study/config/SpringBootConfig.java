package com.imooc.springboot.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zmf
 * @date 2020/3/24 5:18 下午
 */
@Data
@Component
@ConfigurationProperties(prefix = "imooc.springboot")
public class SpringBootConfig {

    private String version;

    private String name;

}
