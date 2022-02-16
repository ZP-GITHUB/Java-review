package com.zp;

import java.util.concurrent.CountDownLatch;

/**
 * @author ZP
 * @date 2022/2/16.
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        sixCountry();
    }

    private static void sixCountry() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "国，灭亡");
                countDownLatch.countDown();
            }, CountryEnum.forEach(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println("秦统一");
    }
}
