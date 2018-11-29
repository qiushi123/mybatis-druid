package com.example.demo.aop.cglib;

import com.example.demo.aop.FanSheUtils;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by qcl on 2018/11/29
 * desc:工厂类：用来生产已经加入切面逻辑的增强过目标类
 */
public class Factory {
    public static Base getInstance(CglibProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        //回调方法的参数为代理类对象CglibProxy,最后增强目标类调用的是
        // 代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(proxy);
        //此刻，base不是单车的目标类，而是增强过的目标类
        Base base = (Base) enhancer.create();
        return base;

    }

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Base base = Factory.getInstance(proxy);
        //        base.add();

        //验证base
        Class<? extends Base> baseClass = base.getClass();
        //查看增强过的类的父类是不是未增强的Base类
        System.out.println(baseClass.getSuperclass().getName());
        //打印增强过的类的所有方法
        FanSheUtils.printMethods(baseClass);

        System.out.println("============================");

        Base base1 = new Base();
        System.out.println(base1.getClass().getSuperclass().getName());
        FanSheUtils.printMethods(base1.getClass());//打印没有增强过的类的所有方法

    }
}
