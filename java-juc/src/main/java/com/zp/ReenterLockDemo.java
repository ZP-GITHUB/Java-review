package com.zp;

/**
 * @author ZP
 * @date 2022/2/11.
 */
class Phone{
    public synchronized void sendSms(){
        System.out.println(Thread.currentThread().getName() + "\tsendSms");
        sendEnail();
    }

    private synchronized void sendEnail() {
        System.out.println(Thread.currentThread().getName() + "\tsendEnail");
    }
}

/**
 * Description:
 *  可重入锁(也叫做递归锁)
 *  指的是同一先生外层函数获得锁后,内层敌对函数任然能获取该锁的代码
 *  在同一线程外外层方法获取锁的时候,在进入内层方法会自动获取锁
 *
 *  也就是说,线程可以进入任何一个它已经标记的锁所同步的代码块
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSms();
        }, "t1").start();

        new Thread(() -> {
            phone.sendSms();
        }, "t2").start();
    }
}
