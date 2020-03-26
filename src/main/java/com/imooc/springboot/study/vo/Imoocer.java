package com.imooc.springboot.study.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zmf
 * @date 2020/3/25 12:19 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"address","name"})
public class Imoocer {

    private String name;

    private Integer age;

//    @JsonIgnore
    private String address;

    @JsonProperty("rt")//序列化为名为rt的对象
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//jackson默认将时间格式化为Long类型时间戳，pattern可以规定格式化后的格式
    private Date registerTime;


}
