package com.ch.leetcodetest.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @User: chang
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //剩余可执行个数
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    //-1
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒离开");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    //+1
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }
    }
}
