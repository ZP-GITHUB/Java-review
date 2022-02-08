package com.zp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ZP
 * @date 2022/2/8.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
class User{
    private String name;
    private int age;
}

public class AtomicRefernceDemo {
    public static void main(String[] args) {
        User zs = new User("zs", 22);
        User ls = new User("ls", 22);
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(zs);
        /**如果userAtomicReference里是zs，则把ls和zs交换，所以第一次会成功 true*/
        System.out.println(userAtomicReference.compareAndSet(zs, ls) + "\t" + userAtomicReference.get().toString());
        /**第二次因为userAtomicReference里是ls，不是zs，所以失败*/
        System.out.println(userAtomicReference.compareAndSet(zs, ls) + "\t" + userAtomicReference.get().toString());
    }
}
