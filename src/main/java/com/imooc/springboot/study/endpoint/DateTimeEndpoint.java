package com.imooc.springboot.study.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义事件端点
 * @author zmf
 * @date 2020/3/25 11:14 上午
 */
@Endpoint(id = "dateTime")
public class DateTimeEndpoint {

    private String format = "yyyy-MM-dd HH:mm:ss";

    /**
     * 显示监控指标
     * @return
     */
    @ReadOperation
    public Map<String,Object> info(){
        Map<String, Object> info = new HashMap<>();
        info.put("name","xiaoming");
        info.put("age","19");
        info.put("dateTime",new SimpleDateFormat(format).format(new Date()));

        return info;
    }

    /**
     * 动态更改监控指标
     * 需要post方式
     * @param format
     */
    @WriteOperation
    public void setFormat(String format){
        this.format = format;
    }


}
