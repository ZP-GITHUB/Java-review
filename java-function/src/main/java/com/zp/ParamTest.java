package com.zp;

/**
 * @author ZP
 * @date 2021/6/2.
 */
public class ParamTest {
    public static void main(String[] args) {
        /*
         * Test 1: Methods can't modify numeric parameters
         * 值传递
         */

        System.out.println("Testing tripieValue:") ;
        double percent = 10;
        System.out.println("Before: percent " + percent);
        tripieValue(percent);
        System.out.println("After: percent=" + percent) ;
         /*
         * Test 2: Methods can change the state of object parameters
         * 改变对象的状态
         */
        System.out.println("\nTesting tri pleSalary:");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripieSalary(harry);
        System.out .println("After: salary=" + harry.getSalary());
        /*
        * Test 3: Methods can ' t attach new objects to object parameters
        * Java 程序设计语言对对象采用的不是引用调用
        * 实际上，对象引用是按值传递的。
        */
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void tripieValue(double x) // doesn't work
    {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }

    public static void tripieSalary(Employee x) // works
    {
        x.raiseSalary(200);
        System.out.println("End of method: salary=" + x.getSalary());
    }

    public static void swap(Employee x, Employee y) {

        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }
}

class Employee { // simplified Employee class
    private String name;
    private double salary;
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }
    public String getName() {
        return name;
    }
    public double getSalary(){
        return salary;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}