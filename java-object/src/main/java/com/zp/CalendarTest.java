package com.zp;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author ZP
 * @date 2021/5/30.
 */
public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int monthValue = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();

        date = date.minusDays(dayOfMonth - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < value; i++) {
            System.out.println("  ");
            while (date.getMonthValue() == monthValue){
                System.out.printf("%3d", date.getDayOfMonth());
                if (date.getDayOfMonth() == dayOfMonth)
                    System.out.print("*");
                else
                    System.out.print(" ");
                date = date.plusDays(1);
                if (date.getDayOfWeek().getValue() == 1) System.out.println();
            }
            if (date.getDayOfWeek().getValue() != 1)
                System.out.println();
        }
    }
}
