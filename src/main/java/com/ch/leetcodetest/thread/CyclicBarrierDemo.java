package com.ch.leetcodetest.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @User: chang
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(99,()->{
            System.out.println("召唤神龙");
        });
        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t "+"得到龙珠 "+tmp);
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
