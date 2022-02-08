package com.zp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author ZP
 * @date 2022/2/8.
 */
public class ABADemo {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    private static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100, 1);

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

        System.out.println("====以下是ABA问题得解决===");
        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"\t 第1次版本号"+stamp+"\t值是"+stampedReference.getReference());
            //暂停1秒钟t3线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            stampedReference.compareAndSet(100,101, stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() +"\t 第2次版本号"+stamp+"\t值是"+stampedReference.getReference());

            stampedReference.compareAndSet(101,100, stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() +"\t 第3次版本号"+stamp+"\t值是"+stampedReference.getReference());

        }, "t3").start();

        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第1次版本号" + stamp +"\t值是" + stampedReference.getReference());
            /**保证线程3完成一次ABA*/
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            boolean resunt = stampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+ "\t 修改成功与否" + resunt + "\t最新版本号" + stampedReference.getReference());
            System.out.println("最新的值\t"+stampedReference.getReference());

        }, "t4").start();
    }
}
