package com.zp;

// 导入静态包
import com.zp.corejava.Employee;

import static java.lang.System.*;

/**
 * @author ZP
 * @date 2021/6/4.
 * 如果没有指定public 或private, 这个部分（类、方法或变量）可以被同一个包中的所有方法访问。
 */
public class PackageTest
{
    public static void main(String[] args)
    {
        // because of the import statement, we don't have to use
        // com.horstmann.corejava.Employee here
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        // because of the static import statement, we don't have to use System.out here
        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}