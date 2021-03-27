package com.zp.enums;

/**
 * @author ZP
 * @date 2020/9/13.
 */
public enum WeekEnum {
    SUNDAY("星期日",7),MONDAY("星期一",1),TUESDAY("星期二",2),
    WEDNESDAY("星期三",3),THURSDAY("星期四",4),FRIDAY("星期五",5),SATURDAY("星期六",6);

    private String name;
    private int index;
    //构造方法
    private WeekEnum(String name,int index){
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}