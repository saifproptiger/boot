package com.saif.demo.cache.util;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

public class CustomRedisKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder keyBuilder = new StringBuilder(target.getClass().getSimpleName() + ":" + method.getName() + ":");
        int hashCode = 17;
        for (Object param : params) {
            hashCode = 31 * hashCode + param.hashCode();
        }
        keyBuilder.append(hashCode);
        return keyBuilder.toString();
    }

}
