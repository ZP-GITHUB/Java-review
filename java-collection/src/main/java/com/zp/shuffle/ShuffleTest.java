package com.zp.shuffle;

import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class ShuffleTest
{
   public static void main(String[] args)
   {
      List<Integer> numbers = new ArrayList<>();
      for (int i = 1; i <= 49; i++)
         numbers.add(i);
      // 打乱顺序
      Collections.shuffle(numbers);
      // 取5个
      List<Integer> winningCombination = numbers.subList(0, 6);
      System.out.println(winningCombination);
      Collections.sort(winningCombination);
      System.out.println(winningCombination);
   }
}
