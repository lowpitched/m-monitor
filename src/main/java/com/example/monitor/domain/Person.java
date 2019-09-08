package com.example.monitor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("person")
public class Person implements Serializable {
    @TableId(value="id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String country;
    private String phone;
    private Integer age;
    private String email;
    private String birthday;


}
