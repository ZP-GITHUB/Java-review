package com.zp;

import java.time.LocalDate;

/**
 * @author ZP
 * @date 2021/5/30.
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("zp", 72000, 1997,2,4);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // raise everyone's salary by 5%  加薪5%
        for (Employee e : staff)
            e.raiseSalary(5);
        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hi reDay="
                    + e.getHireDay());
    }

}


class Employee{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month , int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year , month, day);;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }


    public void raiseSalary(int byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}