package com.zp;

/**
 * @author ZP
 * @date 2021/5/29.
 * 数组初始化
 */
public class InitArray {
    public static void main(String[] args) {
        /**创建数组对象并且赋予初始值*/
        int [] smallPerimes = {2, 3, 5, 7, 11, 13};
        for (int n : smallPerimes) {
            System.out.print(n + " ");
        }
        System.out.println("\n=========================");
        /**初始化匿名数组*/
        int [] smallPerimes1 = new int[] { 17, 19, 23, 29, 31, 37 };
        for (int n : smallPerimes1) {
            System.out.print(n + " ");
        }


    }
}
