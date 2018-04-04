package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * 线程安全概念：当多个线程访问一类（类或者方法的时候），这个对象始终能表现出正确的行为内，那么这个类（对象或者方法）就是线程安全的。
 * synchronied ：可以在任何对象或者方法上加锁，而加锁的这段代码称为“互斥区”或则临界区
 */
public class MyThread extends Thread {
    private int count=5;

    public static void main(String[] args) {
        /**
         * 分析：当多个线程访问myThread的run方法的时候,以排队的方式进行处理（这里是排队按照CPU分配的先后顺序而定的）
         *          一个线程想要执行synchronized代码体的内容：
         *          1.尝试拿到锁
         *          2.如果拿到锁，执行synchronized代码的内容：拿不到锁，这个线程就会不断的尝试获取这把锁，直到拿到为止
         *          而且是多个线程同时去竞争这把锁
         */

        MyThread myThread=new MyThread();
        Thread t1=new Thread(myThread);
        Thread t2=new Thread(myThread);
        Thread t3=new Thread(myThread);
        Thread t4=new Thread(myThread);
        Thread t5=new Thread(myThread);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    public synchronized void run(){
        System.out.println(Thread.currentThread().getName()+" "+"count: "+count);
        count--;
    }
}
