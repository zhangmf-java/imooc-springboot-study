package com.imooc.springboot.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.springboot.study.config.SpringBootConfig;
import com.imooc.springboot.study.vo.Imoocer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

/**
 * 测试controller
 * @author zmf
 * @date 2020/3/24 5:05 下午
 */
@Slf4j
@RestController
@RequestMapping("/springboot")
public class Controller {

    /** SpringBootConfig*/
    private SpringBootConfig springBootConfig;


    /** ObjectMapper*/
    private final ObjectMapper mapper;

    @Value("${imooc.springboot.version}")
    private String version;

    @Value("${imooc.springboot.name}")
    private String name;

    @Autowired
    public Controller(SpringBootConfig springBootConfig,ObjectMapper mapper){
        this.springBootConfig = springBootConfig;
        this.mapper = mapper;
    }

    /**
     * 第一种方式的数据注入
     * 127.0.0.1:8000/imooc/springboot/conf_inject_1
     */
    @GetMapping("/conf_inject_1")
    public void firstConfInject(){
        log.info("first conf inject :{},{}",version,name);
    }

    /**
     * 第二种方式的数据注入
     * 127.0.0.1:8000/imooc/springboot/conf_inject_2
     */
    @GetMapping("/conf_inject_2")
    public void secondConfInject(){
        log.info("first conf inject :{},{}",springBootConfig.getVersion(),springBootConfig.getName());
    }



    public Imoocer jackson() throws IOException {
        Imoocer imooc = Imoocer.builder().age(19).name("imooc").registerTime(new Date()).build();
        //序列化方式
        String jacksonImoocer = mapper.writeValueAsString(imooc);
        log.info("imoocer jackson: {}",jacksonImoocer);
         return mapper.readValue(jacksonImoocer,Imoocer.class);

    }

}
