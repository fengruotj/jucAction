package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * synchronized对象锁的同步和异步
 */
public class MyObject {
    public static void main(String[] args) {
        final MyObject myObject=new MyObject();

        /**
         * 分析：
         * t1线程先持有objcet对象锁，t2线程可以以异步的方式调用对象中的 synchronized修饰的方法
         * t1线程先持有objcet对象锁，t2线程如果在这个时候调用对象的同步方法（synchronized修饰的方法）方法则需要等待，也就是同步
         */
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                myObject.method1();
            }
        },"t1");

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                myObject.method2();
            }
        },"t2");

        t1.start();
        t2.start();
    }

    public synchronized void method1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2(){
        System.out.println(Thread.currentThread().getName());
    }
}
