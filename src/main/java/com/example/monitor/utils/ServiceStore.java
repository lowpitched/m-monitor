package com.example.monitor.utils;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.Map;

public final class ServiceStore {

    private ServiceStore(){

    }

    private static Map<Class, IService> serviceStore = new HashMap<>();

    public static void setService(Class<?> entityClass,IService service){
        serviceStore.put(entityClass,service);
    }

    public static<T> IService<T> getService(Class<T> entityClass){
        return serviceStore.get(entityClass);
    }

}
