package com.zp;

import java.util.Random;

/**
 * @author ZP
 * @date 2021/6/3.
 */
public class ConstructorTest {
    public static void main(String[] args)
    {
        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                    + e.getSalary());
    }
}
class Employee
{
    private static int nextId;

    private int id;
    private String name = ""; // instance field initialization
    private double salary;

    // static initialization block
    // 初始化静态代码块  静态在所有之前
    static
    {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    // object initialization block
    // 初始化对象代码块  首
    // 先运行初始化块，然后才运行构造器的主体部分。
    {
        id = nextId;
        nextId++;
    }

    // three overloaded constructors
    public Employee(String n, double s)
    {
        name = n;
        salary = s;
    }

    public Employee(double s)
    {
        // calls the Employee(String, double) constructor
        // 关键字this 引用方法的隐式参数
        this("Employee #" + nextId, s);
    }

    // the default constructor
    // 无参数构造器，数值类型设置为0，布尔类型设置为false，对象变量设置为null
    public Employee()
    {
        // name initialized to ""--see above
        // salary not explicitly set--initialized to 0
        // id initialized in initialization block
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getId()
    {
        return id;
    }
}
