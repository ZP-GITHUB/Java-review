package com.zp.enums;

/**
 * @author ZP
 * @date 2020/9/13.
 */
public enum FavouriteColor {
    //枚举成员
    RED,GREEN,BLACK,BLUE,WHITE,BROWN;

    // 非枚举类型的成员
    private int colorValue;

    //无参构造器
    private FavouriteColor() {}


        //有参构造器
    FavouriteColor(int colorValue) {
        this.colorValue = colorValue;
    }
}
