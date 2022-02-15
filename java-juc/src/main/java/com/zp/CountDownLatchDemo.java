package com.zp;

import java.util.concurrent.CountDownLatch;

/**
 * @author ZP
 * @date 2022/2/15.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        closeDoor();
    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "上完自习");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t班长锁门离开教室");
    }
}
