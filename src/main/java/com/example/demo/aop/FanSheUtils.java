package com.example.demo.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by qcl on 2018/11/29
 * desc:
 */
public class FanSheUtils {

    //打印该类的所有方法
    public static void printMethods(Class cl) {
        System.out.println();
        //获得包含该类所有其他方法的数组
        Method[] methods = cl.getDeclaredMethods();
        //遍历数组
        for (Method method : methods) {
            System.out.print("  ");
            //获得该方法的修饰符并打印
            String modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            //打印方法名
            System.out.print(method.getName() + "(");

            //获得该方法包含所有参数类型的Class对象的数组
            Class[] paramTypes = method.getParameterTypes();
            //遍历数组
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }
}
