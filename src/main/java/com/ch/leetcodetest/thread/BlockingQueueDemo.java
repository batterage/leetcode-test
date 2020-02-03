package com.ch.leetcodetest.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @User: chang
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //出范围抛异常的情况，插入--查看队首--队首出队
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        //不报异常系列,返回成功失败,查询没有返回null。插入--查看队首--队首出队
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        //出范围就阻塞  插入---移除,没有查看队首
        blockingQueue.put("a");
        System.out.println(blockingQueue.take());
        //超过时间放弃 插入---移除,没有查看队首
        System.out.println(blockingQueue.offer("a",1, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));
    }
}
