package com.example.monitor.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.monitor.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface PersonMapper extends BaseMapper<Person> {

}
