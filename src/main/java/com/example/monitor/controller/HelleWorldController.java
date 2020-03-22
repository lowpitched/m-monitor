package com.example.monitor.controller;

import com.alibaba.fastjson.JSON;
import com.example.monitor.common.BasePojo;
import com.example.monitor.common.CommonResult;
import com.example.monitor.common.PaginationVo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class HelleWorldController {

    @GetMapping("/list")
    public PaginationVo<Person> person(String name){
        List<Person> result = new ArrayList<>();
        for(int i=0;i<10;i++){
            Person p = new Person();
            p.setId(i+"");
            p.setName("zhangsan"+i);
            p.setAge(i);
            p.setDate(new Date());
            result.add(p);
        }
        PaginationVo page = new PaginationVo(result,10,1,100);
        System.out.println("11111111111111111");
        return page;
    }

    @PutMapping("/edit")
    public CommonResult edit(Person person) {
        System.out.println(JSON.toJSONString(person));
        return new CommonResult();
    }

    public static class Person extends BasePojo {
        private String id;
        private String name;
        private int age;
        private Date date;

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
}
