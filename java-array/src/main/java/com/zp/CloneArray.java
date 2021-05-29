package com.zp;

import java.util.Arrays;

/**
 * @author ZP
 * @date 2021/5/29.
 * 数组拷贝
 */
public class CloneArray {
    public static void main(String[] args) {
        int[] smallPerimes = {2, 3, 5, 7, 11, 13};
        /**直接用等号把两个变量引用同一个数组*/
        int[] luckyNumber = smallPerimes;
        /**smallPerimes[5]也变成了12*/
        luckyNumber[5] = 12;
        for (int n : smallPerimes) {
            System.out.print(n + " ");
        }
        System.out.println("\n===========Arrays.copyOf==============");

        /**第二个参数是新数组的长度，这个方法通常用来增加数组的大小。
         * 如果大于原数组长度，int的补充0，布尔类型补充false
         * 小于原数组只考前面的*/
        int[] copiedLuckyNumber = Arrays.copyOf(luckyNumber, luckyNumber.length);
        for (int n : copiedLuckyNumber) {
            System.out.print(n + " ");
        }
        System.out.println("\n=========================");

    }
}
