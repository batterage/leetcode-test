package com.ch.leetcodetest.thread;

import java.util.concurrent.TimeUnit;

/**
 * @User: chang
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" come in");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
            System.out.println(Thread.currentThread().getName()+" come out,number="+myData.number);
        },"AA").start();
        while (myData.number==0){

        }
        System.out.println("number != 0");
        //volatile不保证原子性
        myData.number=0;
        for (int i=1;i<=20;i++){
            new Thread(()->{
                for (int j=1;j<1000;j++){
                    myData.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }
        //Thread.activeCount()返回活动线程的当前线程的线程组中的数量
        while (Thread.activeCount()>2){
            //Thread.yield()当前线程从执行状态（运行状态）变为可执行态（就绪状态）
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value :"+myData.number);
    }
}
class MyData{
    /*
    如何解决volatile的不保证原子性
    1. synchronized
    2. AtomicInteger
    */

    //添加volatile可以是该变量可见性
    volatile int number = 0 ;
    public void add(){
        number = 40;
    }
    public void addPlusPlus(){
        number++;
    }
}
