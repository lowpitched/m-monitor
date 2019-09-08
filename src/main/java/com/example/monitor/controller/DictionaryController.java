package com.example.monitor.controller;

import com.example.monitor.inum.CountryEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    @RequestMapping("/dictCountry")
    public List<Map<String,String>> dictCountry(){
        System.out.println("----------------");
        return CountryEnum.toMap();
    }

}
