package com.example.monitor.inum;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum CommonResultEnum implements BaseEnum<CommonResultEnum>{

    CODE_SUCCESS("0000","成功","成功"),
    CODE_ERROR_COMMON("0001","一般错误","一般错误"),
    CODE_ERROR_UNKONWN("1000","未知错误","未知错误");

    private String code;
    private String name;
    private String desc;

    CommonResultEnum(String code,String name,String desc){
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

}
