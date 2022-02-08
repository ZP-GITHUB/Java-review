package com.zp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ZP
 * @date 2022/2/8.
 */
public class ABADemo {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {
        System.out.println("===以下是ABA问题产生===");
        new Thread(()->{
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(()->{
            /**先暂停1秒保证完成ABA*/
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
        /**这里交换成功，但是t2线程并不知道这个值被交换过*/
        System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get().toString());
    }
}
