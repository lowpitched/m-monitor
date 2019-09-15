package com.example.monitor.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.monitor.inum.DeletedEnum;
import com.example.monitor.utils.ServiceStore;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.Assert;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M,T> implements BeanPostProcessor {


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<T> clazz = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        ServiceStore.setService(clazz,this);
        return bean;
    }

    public boolean batchDelete(String ids) {
        Assert.notNull(ids,"ID不能为空");

        try {
            Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
            String[] ida = ids.split(",");
            List<T> updateList = new ArrayList<>(ida.length);
            for (String id : ida) {
                T t = clazz.newInstance();
                BasePojo basePojo = ((BasePojo) t);
                basePojo.setId(Long.parseLong(id));
                basePojo.setDeleted(DeletedEnum.DELETED.getCode());
                basePojo.setModifyTime(new Date());
                updateList.add(t);
            }
            return this.updateBatchById(updateList);
        }catch (Exception e){
            throw new RuntimeException("批量删除失败",e);
        }
    }


}
