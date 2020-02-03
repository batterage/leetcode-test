package com.ch.leetcodetest.thread;

import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @User: chang
 * 读写锁
 */
class MyCache//资源类
{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    public void put(String key, Object value){
        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
            try { TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }finally {
            rwlock.writeLock().unlock();
        }

    }
    public void get(String key){
        rwlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            try { TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
        }finally {
            rwlock.readLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(()->{
                myCache.put(tmp+"",tmp);
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(()->{
                myCache.get(tmp+"");
            },String.valueOf(i)).start();
        }

    }
}
