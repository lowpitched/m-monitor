package com.example.monitor.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.monitor.anotation.query.DoWrapper;
import com.example.monitor.exception.ConvertQueryWrapperException;
import org.apache.commons.lang3.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QueryWrapperUtils {

    public static final String _GE = "_GE";

    public static final String _LE = "_LE";

    public static<T> QueryWrapper<T> toQueryWrapper(T entity){
        try {
            return toQueryWrapper(entity, true);
        }catch (Exception e){
            e.printStackTrace();
            throw new ConvertQueryWrapperException("转换queryWrapper出错");
        }
    }


    public static<T> QueryWrapper<T> toQueryWrapper(T entity,boolean ignoreEmpty)
            throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        QueryWrapper queryWrapper = new QueryWrapper();
        //queryWrapper.eq("deleted", DeletedEnum.UN_DELETED.getCode());
        if(null == entity){
            return queryWrapper;
        }
        Class<?> aClass = entity.getClass();
        while(null != aClass.getSuperclass() && Object.class != aClass){
            Field[] fields = aClass.getDeclaredFields();
            for(Field field : fields){
                String fieldName = field.getName();
                if("serialVersionUID".equals(fieldName)){
                    continue;
                }
                String rawColumnName = null;
                Annotation doWrapperAnnotation = field.getDeclaredAnnotation(DoWrapper.class);
                if(null != doWrapperAnnotation){
                    Method method = doWrapperAnnotation.annotationType().getDeclaredMethod("wrapperIgnore");
                    if(null != method && (boolean)method.invoke(doWrapperAnnotation)){
                        continue;
                    }
                    Method rawColumn = doWrapperAnnotation.annotationType().getDeclaredMethod("rawColumn");
                    if(null != rawColumn){
                        rawColumnName = (String)rawColumn.invoke(doWrapperAnnotation);
                    }
                }
                if(StringUtils.isEmpty(rawColumnName)){
                    rawColumnName = StringTools.camelToUnderline(fieldName);
                }
                Object value = invokeValue(fieldName,entity);
                if(!isCondition(value,ignoreEmpty)){
                    continue;
                }else{
                    if(fieldName.endsWith(_LE)){
                        queryWrapper.le(StringTools.camelToUnderline(subSuffix(fieldName,_LE)),value);
                    }else if(fieldName.endsWith(_GE)){
                        queryWrapper.ge(StringTools.camelToUnderline(subSuffix(fieldName,_GE)),value);
                    }else{
                        queryWrapper.eq(rawColumnName,value);
                    }
                }
            }
            aClass = aClass.getSuperclass();
        }
        return queryWrapper;
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
