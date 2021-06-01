package com.zp.staticdemo;

/**
 * @author ZP
 * @date 2021/6/1.
 */
public class StaticTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for (Employee e : staff) {
            e.setld();
            System.out.println("name=" + e.getName() + ",id=" + e.getld() + ".salary:"
                    + e.getSalary());
        }

        int nextld = Employee.getNextld();
        System.out.println("Next available id = " + nextld);
    }
}

class Employee
{
    private static int nextld = 1;
    private String name;
    private double salary;
    private int id;
    public Employee(String n, double s)
    {
        name = n;
        salary = s;
        id = 0;
    }
    public String getName()
    {
        return name;
    }
    public double getSalary()
    {
        return salary;
    }
    public int getld()
    {
        return id;
    }
    public void setld()
    {
        id = nextld; // set id to next available id
        nextld++;
    }
    public static int getNextld()
    {
        return nextld; // returns static field
    }
    public static void main(String[] args) // unit test
    {
        Employee e = new Employee("Harry" , 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}