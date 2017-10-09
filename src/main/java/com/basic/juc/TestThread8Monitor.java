package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/9.
 * 题目：判断打印的“one” or "two" ?
 *
 * 1.两个普通同步方法，两个线程，标准打印，打印？//one two
 * 2.新增 Thread.sleep方法给getOne。打印？ // one two
 * 3.新增普通方法getThree()。 打印？ //three one two
 * 4.两个普通同步方法，两个同步Number对象。 打印？//two one
 * 5.修改getOne()为静态同步方法。 打印？ //two one
 * 6.修改两个方法均为静态同步方法，一个Number对象。打印？//one two
 * 7.一个静态同步方法，一个非静态同步方法，两个Number对象？ //two one
 * 8.两个静态同步方法，两个Number对象？打印 //one two
 *
 * 线程八锁关键点
 * 1.非静态方法的锁默认为 this，静态方法的锁为对于的Class实例
 * 2.在某一个时刻内，只有一个线程持有锁，无论有几个方法。
 */
public class TestThread8Monitor {
    public static void main(String[] args) {
        final Number number1=new Number();
        //final Number number2=new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number1.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number1.getTwo();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                number.getThree();
//            }
//        }).start();
    }
}

class Number{
    public static synchronized void getOne(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }
    public static synchronized void getTwo(){
        System.out.println("two");
    }

//    public void getThree(){
//        System.out.println("three");
//    }
}
