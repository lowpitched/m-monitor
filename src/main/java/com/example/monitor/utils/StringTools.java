package com.example.monitor.utils;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class StringTools {

    private static final char UNDERLINE='_';

    private static Cache<String,String> localCache;

    static{
        localCache = CacheBuilder.newBuilder().maximumSize(2000).expireAfterAccess(2, TimeUnit.HOURS).build();
    }
    /**
     * 驼峰字段转下划线字段
     *
     * @param param
     * @return
     */
    public static String camelToUnderline(String param){
        try{
            return localCache.get(param, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    if (param==null ||"".equals(param.trim())){
                        return "";
                    }
                    int len=param.length();
                    StringBuilder sb=new StringBuilder(len);
                    for (int i = 0; i < len; i++) {
                        char c=param.charAt(i);
                        if (Character.isUpperCase(c)){
                            sb.append(UNDERLINE);
                            sb.append(Character.toLowerCase(c));
                        }else{
                            sb.append(c);
                        }
                    }
                    return sb.toString();
                }
            });
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
