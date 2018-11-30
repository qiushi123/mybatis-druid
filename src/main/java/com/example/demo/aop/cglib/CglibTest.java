package com.example.demo.aop.cglib;

import com.example.demo.aop.FanSheUtils;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by qcl on 2018/11/29
 * desc:测试类
 */
public class CglibTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        //回调方法的参数为代理类对象CglibProxy,最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(proxy);
        //此刻，base不是单车的目标类，而是增强过的目标类
        Base base = (Base) enhancer.create();
        base.add();

        Class<? extends Base> baseClass = base.getClass();
        //查看增强过的类的父类是不是未增强的Base类
        System.out.println("增强过的类的父类："+baseClass.getSuperclass().getName());
        System.out.println("============打印增强过的类的所有方法==============");
        FanSheUtils.printMethods(baseClass);


        //没有被增强过的base类
        Base base2 = new Base();
        System.out.println("未增强过的类的父类："+base2.getClass().getSuperclass().getName());
        System.out.println("=============打印增未强过的目标类的方法===============");
        FanSheUtils.printMethods(base2.getClass());//打印没有增强过的类的所有方法

    }
}
