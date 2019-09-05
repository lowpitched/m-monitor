package com.example.monitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/helloWorld")
public class HelleWorldController {

    @GetMapping("/hello")
    public List<Person> hello(String name){
        List<Person> result = new ArrayList<>();
        for(int i=0;i<100;i++){
            Person p = new Person();
            p.setId(i+"");
            p.setName("zhangsan"+i);
            p.setAge(i);
            p.setDate(new Date());
            result.add(p);
        }
        System.out.println("11111111111111111");
        return result;
    }

    class Person {
        private String id;
        private String name;
        private int age;
        private Date date;

        public String getId() {
            return id;
        }

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
