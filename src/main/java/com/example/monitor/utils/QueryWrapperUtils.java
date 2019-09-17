package com.example.monitor.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.monitor.anotation.query.DoWrapper;
import com.example.monitor.exception.ConvertQueryWrapperException;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Log
public class QueryWrapperUtils {

    public static final String _GE = "_GE";

    public static final String _LE = "_LE";

    public static<T> QueryWrapper<T> toQueryWrapper(T entity){
        return toQueryWrapper(entity, true);
    }


    public static<T> QueryWrapper<T> toQueryWrapper(T entity,boolean ignoreEmpty) {
        try {
            QueryWrapper queryWrapper = new QueryWrapper();
            if (null == entity) {
                return queryWrapper;
            }
            Class<?> aClass = entity.getClass();
            while (null != aClass.getSuperclass() && Object.class != aClass) {
                Field[] fields = aClass.getDeclaredFields();
                for (Field field : fields) {
                    String fieldName = field.getName();
                    if ("serialVersionUID".equals(fieldName) || doWrapperIgnore(field)) {
                        continue;
                    }
                    Object value = invokeValue(fieldName, entity);
                    if (!isCondition(value, ignoreEmpty)) {
                        continue;
                    } else {
                        if (fieldName.endsWith(_LE)) {
                            String srcFieldName = subSuffix(fieldName, _LE);
                            Field srcField = aClass.getDeclaredField(srcFieldName);
                            queryWrapper.le(fieldRawColumn(srcField), value);
                        } else if (fieldName.endsWith(_GE)) {
                            String srcFieldName = subSuffix(fieldName, _GE);
                            Field srcField = aClass.getDeclaredField(srcFieldName);
                            queryWrapper.ge(fieldRawColumn(srcField), value);
                        } else {
                            queryWrapper.eq(fieldRawColumn(field), value);
                        }
                    }
                }
                aClass = aClass.getSuperclass();
            }
            return queryWrapper;
        }catch (Exception e){
            e.printStackTrace();
            throw new ConvertQueryWrapperException("构建queryWrapper出错",e);
        }
    }

    private static String fieldRawColumn(Field field){
        DoWrapper doWrapper = field.getDeclaredAnnotation(DoWrapper.class);
        if(null == doWrapper){
            return StringTools.camelToUnderline(field.getName());
        }
        String rawColumn = doWrapper.rawColumn();
        if(StringUtils.isEmpty(rawColumn)){
            return StringTools.camelToUnderline(field.getName());
        }else{
            return rawColumn;
        }
    }

    private static boolean doWrapperIgnore(Field field){
        DoWrapper doWrapper = field.getDeclaredAnnotation(DoWrapper.class);
        if (null == doWrapper || !doWrapper.wrapperIgnore()) {
            return false;
        }
        return true;
    }

    private static String subSuffix(String fieldName,String suffix){
        int index = fieldName.lastIndexOf(suffix);
        return fieldName.substring(0,index);
    }

    private static<T> Object invokeValue(String fieldName,T entity)
            throws InvocationTargetException, IllegalAccessException, IntrospectionException {
        PropertyDescriptor pd = new PropertyDescriptor(fieldName,entity.getClass());
        Method readMethod = pd.getReadMethod();
        return readMethod.invoke(entity);
    }

    private static boolean isCondition(Object value,boolean ignoreEmpty){
        if(null == value){
            return false;
        }
        if(StringUtils.isEmpty(value.toString()) && ignoreEmpty){
            return false;
        }
        return true;
    }


}
