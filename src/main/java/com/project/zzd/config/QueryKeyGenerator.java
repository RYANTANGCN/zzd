package com.project.zzd.config;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class QueryKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append(method.toString());
        for (Object object : params) {
            stringBuffer.append(":"+object.toString());
        }
        return stringBuffer.substring(1).toString();
    }
}
