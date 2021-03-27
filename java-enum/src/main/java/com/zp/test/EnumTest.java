package com.zp.test;

import com.zp.enums.FavouriteColor;
import com.zp.enums.WeekEnum;
import org.junit.Test;

/**
 * @author ZP
 * @date 2020/9/13.
 */
public class EnumTest {

    @Test
    public void test(){
        System.out.println(FavouriteColor.BLUE);
    }

    @Test
    public void test1(){
        for (WeekEnum w : WeekEnum.values()) {
            System.out.println("序号:"+w.ordinal()+"  枚举名称:"+w.name()+"  属性name值:"+w.getName()+"  属性index值:"+w.getIndex());
        }
    }
}
