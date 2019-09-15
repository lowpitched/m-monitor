package com.example.monitor.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.monitor.common.CommonResult;
import com.example.monitor.common.BasePojo;
import com.example.monitor.common.PaginationVo;
import com.example.monitor.inum.CommonResultEnum;
import com.example.monitor.utils.QueryWrapperUtils;
import com.example.monitor.utils.ServiceStore;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BaseController<T extends BasePojo> {

    private IService<T> service;

    {
        Class<T> clazz = (Class<T>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        this.service = ServiceStore.getService(clazz);
    }

    @GetMapping("/list")
    public CommonResult list(int pageSize, int currentPage, T query){
        IPage<T> page = service.page(new Page<T>(currentPage,pageSize), QueryWrapperUtils.toQueryWrapper(query));
        return CommonResult.instance(new PaginationVo(page));
    }

    @PostMapping("/add")
    public CommonResult add(T entity){
        BasePojo basePojo = (BasePojo)entity;
        basePojo.setCreateTime(new Date());
        basePojo.setModifyTime(new Date());
        boolean result = service.save(entity);
        if(result){
            return CommonResult.instance(CommonResultEnum.CODE_SUCCESS);
        }else{
            return CommonResult.instance(CommonResultEnum.CODE_ERROR_COMMON,"新增失败");
        }
    }

    @PutMapping("/edit")
    public CommonResult edit(T entity){
        Assert.notNull(entity.getId(),"更新操作ID不能为空");
        BasePojo basePojo = (BasePojo)entity;
        basePojo.setModifyTime(new Date());
        boolean result = service.updateById(entity);
        if(result){
            return CommonResult.instance(CommonResultEnum.CODE_SUCCESS);
        }else{
            return CommonResult.instance(CommonResultEnum.CODE_ERROR_COMMON,"修改失败");
        }
    }

    @DeleteMapping("/delete/{ids}")
    public CommonResult delete(@PathVariable("ids") String ids){
        Assert.notNull(ids,"删除操作ID不能为空");
        new ArrayList<T>();
        List<String> ida = Arrays.asList(ids.split(","));
        boolean result = service.removeByIds(ida);
        if(result){
            return CommonResult.instance(CommonResultEnum.CODE_SUCCESS);
        }else{
            return CommonResult.instance(CommonResultEnum.CODE_ERROR_COMMON,"删除失败");
        }
    }

}
