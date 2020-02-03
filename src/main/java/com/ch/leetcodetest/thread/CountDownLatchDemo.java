package com.ch.leetcodetest.thread;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;

/**
 * @User: chang
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 同学离开教室");
                //计数器减1
                countDownLatch.countDown();
            },CountTryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        //让一些线程阻塞直到另一个线程完成一系列操作后才被唤醒
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 班长关门走人");

    }
}
enum CountTryEnum{
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),
    SIX(0,"韩"),FIVE(5,"魏");
    @Getter private Integer retCode;
    @Getter private String retMessage;
    CountTryEnum(Integer retCode,String retMessage){
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public static CountTryEnum forEach_CountryEnum(int retCode){
        CountTryEnum[] myArray = CountTryEnum.values();
        for (int i=0;i<myArray.length;i++){
            if (myArray[i].retCode==retCode){
                return myArray[i];
            }
        }
        return null;
    }
}
