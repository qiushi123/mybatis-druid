package com.example.demo.demos;

import java.lang.reflect.Method;

/**
 * Created by qcl on 2018/11/19
 * desc:
 */
public class HaspMapDemo {
    public static void main(String[] args) {
        A a = new A();
        Class aClass = a.getClass();
        try {
            //            Class<?> aClass = Class.forName("com.example.demo.demos.A");
            System.out.println(aClass.getName());
            Method add = aClass.getDeclaredMethod("add", int.class, int.class);
            add.invoke(aClass.newInstance(), 10, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A {
    void add(int a, int b) {
        System.out.println(a + b);

    }
}