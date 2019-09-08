package com.example.monitor.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.example.monitor.dao.PersonMapper;
import com.example.monitor.domain.PaginationVo;
import com.example.monitor.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/list")
    public PaginationVo<Person> list(int pageSize, int currentPage, Person query){
        List<Person> data = personMapper.selectList(null);
        Integer totalCount = personMapper.selectCount(null);
        PaginationVo result = new PaginationVo(data,pageSize,currentPage,Integer.parseInt(totalCount+""));
        return result;
    }

    @DeleteMapping("/delete/{ids}")
    public String delete(@PathVariable("ids") String ids){
        Assert.isTrue(!StringUtils.isEmpty(ids),"id不能为空");
        personMapper.deleteBatchIds(Arrays.asList(ids.split(",")));
        return "success";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Person person){
        System.out.println(JSON.toJSONString(person));
        personMapper.insert(person);
        return "success";
    }

    @PutMapping("/edit")
    public String edit(@ModelAttribute Person person){
        System.out.println(JSON.toJSONString(person));
        personMapper.updateById(person);
        return "success";
    }

    /*public List<Person> getData(int pageSize,int currPage,Person query){
        List<Person> list = new ArrayList<Person>();
        for(int i=0;i<1023;i++){
            Person p = new Person();
            p.setId(Long.parseLong(i+""));
            p.setAge(i);
            p.setName("mlh"+i);
            p.setCountry("137");
            p.setEmail("mlh@126.com");
            p.setPhone("666666666");
            p.setBirthday("2019-08-10");
            boolean match = false;
            boolean isIn = false;
            if(null!=query.getName()&&query.getName().equals(p.getName())){
                match = true;
                isIn = true;
            }
            if(null!=query.getAge()&&query.getAge().equals(p.getAge())){
                match = true;
                isIn = true;
            }
            if(match||!isIn){
                list.add(p);
            }
        }
        int offset = (currPage-1)*pageSize;
        int toIndex = offset+pageSize;
        return list.subList(offset, toIndex);
    }*/

}
