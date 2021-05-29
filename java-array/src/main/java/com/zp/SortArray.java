package com.zp;

import java.util.Arrays;

/**
 * @author ZP
 * @date 2021/5/29.
 * 数组排序
 */
public class SortArray {
    public static void main(String[] args) {
        int[] smallPerimes = {2, 13, 5, 7, 4, 13};
        /**把数组里元素用逗号隔开展示出来*/
        System.out.println(Arrays.toString(smallPerimes));

        /**排序*/
        Arrays.sort(smallPerimes);
        System.out.println(Arrays.toString(smallPerimes));
    }
}
