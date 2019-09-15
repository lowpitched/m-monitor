package com.example.monitor.utils;

import com.example.monitor.inum.BaseEnum;
import com.example.monitor.inum.DeletedEnum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EnumUtils {

    private EnumUtils(){}

    public static<E> String getNameByCode(Class<E> enumClass,String code)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        E e = getEnumByCode(enumClass,code);
        if(null == e){
            return null;
        }else{
            return ((BaseEnum)e).getCode();
        }
    }

    public static String getValueByName(Class<? extends BaseEnum> enumClass,String name)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object[] enumConstants = enumClass.getEnumConstants();
        Method getName = enumClass.getMethod("getName", null);
        for(Object oneEnum : enumConstants){
            Object n = getName.invoke(oneEnum, null);
            if(n.equals(n.toString())){
                Method getCode = enumClass.getMethod("getCode", null);
                return getCode.invoke(oneEnum,null).toString();
            }
        }
        return null;
    }

    public static<E> E getEnumByCode(Class<E> enumClass,String code)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[] enumConstants = enumClass.getEnumConstants();
        Method getCode = enumClass.getMethod("getCode", null);
        for(Object oneEnum : enumConstants){
            Object c = getCode.invoke(oneEnum, null);
            if(code.equals(c.toString())){
                return (E)oneEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String name = getNameByCode(DeletedEnum.class,"1");
        System.out.println(name);
        String value = getValueByName(DeletedEnum.class, "未删除");
        System.out.println(value);
        DeletedEnum inum = getEnumByCode(DeletedEnum.class, "1");
        System.out.println(inum.getName());
    }




}
