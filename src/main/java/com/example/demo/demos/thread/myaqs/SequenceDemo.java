package com.example.demo.demos.thread.myaqs;

/**
 * Created by qcl on 2018/12/20
 * 标题：手把手教你实现ReentrantLock重入锁
 * desc: 用来演示重入锁
 */
public class SequenceDemo {
    //    private Lock lock = new Mylock();
    //    private ReentrantLock lock = new ReentrantLock();
    private MyAQSLock lock = new MyAQSLock();


    private int value;

    private void addValue() {
        lock.lock();
        lock.lock();
        value++;//我们的逻辑操作
        System.out.println(Thread.currentThread().getName() + "-----" + value);
        lock.unlock();
        lock.unlock();
    }


    public static void main(String[] args) {
        SequenceDemo sequenceDemo = new SequenceDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        sequenceDemo.addValue();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}
