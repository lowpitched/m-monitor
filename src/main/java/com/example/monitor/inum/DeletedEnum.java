package com.example.monitor.inum;

import lombok.Getter;

@Getter
public enum DeletedEnum implements BaseEnum<DeletedEnum>{

    UN_DELETED("0","未删除"),
    DELETED("1","已删除");

    private String code;
    private String name;
    DeletedEnum(String code,String name){
        this.code = code;
        this.name = name;
    }

}
