package com.example.monitor.utils;


public class StringTools {

    private static final char UNDERLINE='_';

    /**
     * 驼峰字段转下划线字段
     *
     * @param param
     * @return
     */
    public static String camelToUnderline(String param){
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

}
