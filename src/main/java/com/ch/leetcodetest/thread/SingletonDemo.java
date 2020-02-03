package com.ch.leetcodetest.thread;

/**
 * @User: chang
 */
public class SingletonDemo {

    public static void main(String[] args) {
        /*
        instance = new SingleonDemo();可分为3步
        memory = allocate();//1.分配对象内存空间
        instance(memory);//2.初始化对象
        instance = memory;//3.设置instance指向刚分配的的内存地址，此时instance!=null
        如果指令重排了，2和3顺序可能变换，先执行了3，另一个线程读取到的instance就是null了，但此时instance实例还没有初始化完成。
        所以初始化的时候需要加volatile,
        private static volatile SingletonDemo instance = null;
        */
    }
}
