package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/5/11.
 * /*
 面试题：final修饰局部变量的问题
 基本类型：基本类型的值不能发生改变。
 引用类型：引用类型的地址值不能发生改变，但是，该对象的堆内存的值是可以改变的。
 */
public class TestFinal2 {
    public static void main(String[] args) {
        //局部变量是基本数据类型
        int x = 10;
        x = 100;
        System.out.println(x);
        final int y = 10;
        //无法为最终变量y分配值
        //y = 100;
        System.out.println(y);
        System.out.println("--------------");

        //局部变量是引用数据类型
        Student s = new Student();
        System.out.println(s.age);
        s.age = 100;
        System.out.println(s.age);
        System.out.println("--------------");

        final Student ss = new Student();
        System.out.println(ss.age);
        ss.age = 100;
        System.out.println(ss.age);

        //重新分配内存空间
        //无法为最终变量ss分配值
        //ss = new Student();
    }
}

class Student {
    int age = 10;
}
