package com.ch.leetcodetest.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @User: chang
 */
public class CASDemo {
    public static void main(String[] args) {
        solveExceptionDemo1();
    }
    //集合的线程不安全,java.util.ConcurrentModificationException
    public static void exceptionDemo1(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,10));
                System.out.println(list);
            }).start();
        }
    }
    public static void solveExceptionDemo1(){
        //解决方法1，Vector
        Vector<String> list = new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,10));
                //System.out.println(list);
            }).start();
        }
        //解决方法2，Collections.synchronizedList()
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list1.add(UUID.randomUUID().toString().substring(0,10));
               //System.out.println(list1);
            }).start();
        }
        //解决方法3，new CopyOnWriteArrayList<>()
        //添加元素会把当前容器进行copy，在新容器里添加元素，添加完成后将原来容器的引用指向新的容器。
        //这样的好处是可以对CopyOnWrite进行并发读，而不需要加锁，因为当前容器不会添加新的元素，一种读写分离的思想。
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list2.add(UUID.randomUUID().toString().substring(0,10));
                System.out.println(list2);
            }).start();
        }
    }
}
