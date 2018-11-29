package com.example.demo.demos.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by qcl on 2018/11/20
 * desc:正确的停止线程
 */
public class StopThread {
    private static boolean stop;

    //    private static synchronized void setStop() {
    //        stop = true;
    //    }
    //
    //    private static synchronized boolean getStopValue() {
    //        return stop;
    //    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
                System.out.println(i);
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        stop = true;
        //        setStop();
    }
}



