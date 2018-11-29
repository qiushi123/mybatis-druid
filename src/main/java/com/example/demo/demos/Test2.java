package com.example.demo.demos;

/**
 * Created by qcl on 2018/11/23
 * desc:
 */
public class Test2 {
    public static void main(String[] args) {
        Employee employee = new Employee();
    }
}

class Father {
    public Father() {
        System.out.println("父构造方法");
    }

    static {
        System.out.println("父静态代码块");
    }

    {
        System.out.println("父代码块");
    }
}

class Employee extends Father {
    public Employee() {
        System.out.println("构造方法");
    }

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("代码块");
    }
}