package com.example.monitor.inum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum CountryEnum {

    CHINA("中国","137"),
    JAPAN("日本","138");

    private String name;
    private String code;

    CountryEnum(String name, String code){
        this.name = name;
        this.code = code;
    }

    public static List<Map<String,String>> toMap(){
        List<Map<String,String>> list = new ArrayList<>(2);
        CountryEnum[] values = CountryEnum.values();
        for(CountryEnum inum : values){
            Map<String,String> kv = new HashMap<String,String>(2);
            kv.put("name",inum.name);
            kv.put("code",inum.code);
            list.add(kv);
        }
        return list;
    }

}
