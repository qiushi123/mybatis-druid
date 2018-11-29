package com.example.demo.aop.cglib;

/**
 * Created by qcl on 2018/11/29
 * desc:要被代理的类
 */
public class Base {
    public void add(){
        System.out.println("目标类的add方法");
    }
}
