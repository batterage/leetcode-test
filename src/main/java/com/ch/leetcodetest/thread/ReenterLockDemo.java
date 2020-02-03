package com.ch.leetcodetest.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @User: chang
 */
class Phone{

}

public class ReenterLockDemo implements Runnable {
    public static void main(String[] args) {
        ReenterLockDemo demo = new ReenterLockDemo();
        Thread t1 = new Thread(demo,"t1");
        Thread t2 = new Thread(demo,"t2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        get();
    }
    ReentrantLock lock = new ReentrantLock();
    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+":get");
            set();
        }finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+":set");
        }finally {
            lock.unlock();
        }
    }
}
