package com.example.demo.demos.thread.myaqs;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by qcl on 2018/12/20
 * desc:自定义可重入锁,我们需要记住持有锁的当前线程
 */
public class Mylock implements Lock {

    private boolean isLocked = false;//是否有线程加上锁

    //重入锁的实现
    private Thread lockThread = null;
    private int lockCount = 0;

    @Override
    public synchronized void lock() {
        Thread currentThread = Thread.currentThread();
        if (isLocked && currentThread != lockThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockThread = currentThread;
        lockCount++;
    }

    @Override
    public synchronized void unlock() {
        if (lockThread != Thread.currentThread()) {
            return;
        }
        lockCount--;
        if (lockCount == 0) {
            isLocked = false;
            notify();
            lockThread = null;
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
