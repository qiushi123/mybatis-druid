package com.example.demo.demos.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qcl on 2018/12/20
 * desc:java并发 AQS
 */
public class AQS {
    public static void main(String[] a) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println("锁锁锁");
        lock.unlock();

    }
}
