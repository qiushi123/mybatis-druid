package com.example.demo.demos.thread;

/**
 * Created by qcl on 2018/11/20
 * desc:
 */
public class ThreadDemo1 {
    static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (object1) {
//                    try {
////                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    synchronized (object2) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (object2) {
//                    try {
////                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    synchronized (object1) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        };

        thread.start();
        thread2.start();
        System.out.println("线程1的状态："+thread.getState());
        System.out.println("线程2的状态："+thread2.getState());

    }
}