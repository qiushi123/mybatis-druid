package com.example.demo.aop.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by qcl on 2018/11/29
 * desc:测试
 */
public class JdkTest {
    public static void main(String[] args) {
        JdkClass jdkClass = new JdkClass();
        MyInvocationHandler handler = new MyInvocationHandler(jdkClass);
        // Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例
        //这里的proxyInstance就是我们目标类的增强代理类
        JdkInterface proxyInstance = (JdkInterface) Proxy.newProxyInstance(jdkClass.getClass().getClassLoader(),
                jdkClass.getClass()
                        .getInterfaces(), handler);
        proxyInstance.add();
        //打印增强过的类类型
        System.out.println("=============" + proxyInstance.getClass());

    }
}
