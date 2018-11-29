package com.example.demo.aop.jdk;

/**
 * Created by qcl on 2018/11/29
 * desc: 被代理的类，即目标类target
 */
public class JdkClassImp implements JdkInterface {
    @Override
    public void add() {
        System.out.println("目标类的add方法");
    }

    @Override
    public void update() {
        System.out.println("目标类的update方法");
    }
}
