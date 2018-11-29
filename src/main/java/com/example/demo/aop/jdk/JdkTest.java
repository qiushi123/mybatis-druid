package com.example.demo.aop.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by qcl on 2018/11/29
 * desc:
 */
public class JdkTest {
    public static void main(String[] args) {
        JdkClassImp jdkClassImp = new JdkClassImp();
        MyInvocationHandler handler = new MyInvocationHandler(jdkClassImp);
        // Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例
        JdkInterface proxyInstance = (JdkInterface) Proxy.newProxyInstance(jdkClassImp.getClass().getClassLoader(),
                jdkClassImp.getClass()
                        .getInterfaces(), handler);
        proxyInstance.add();
        System.out.println("============="+proxyInstance.getClass());
        proxyInstance.update();




    }
}
