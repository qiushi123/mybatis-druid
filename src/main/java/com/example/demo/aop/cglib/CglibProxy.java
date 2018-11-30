package com.example.demo.aop.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * Created by qcl on 2018/11/29
 * desc:这里加入切面逻辑
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("before-------切面加入逻辑");
        methodProxy.invokeSuper(object, args);
        System.out.println("after-------切面加入逻辑");
        return null;
    }
}
