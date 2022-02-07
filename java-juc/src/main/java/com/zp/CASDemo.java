package com.zp;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZP
 * @date 2022/2/7.
 * CAS==>比较并交换
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        /**这里交换成功——true，值变成2019*/
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current：" + atomicInteger.get());
        /**这里交换失败，因为值已经不是5了*/
        System.out.println(atomicInteger.compareAndSet(5, 2014)+"\t current：" + atomicInteger.get());

    }
}
