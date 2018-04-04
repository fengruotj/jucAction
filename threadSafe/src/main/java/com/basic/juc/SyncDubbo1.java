package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * 关键字synchronized拥有锁重用的功能，也就是说使用synchronized时，当一个线程获得到一个对象锁后，再次请求此对象的时候时可以再次得到该对象锁的
 */
public class SyncDubbo1 {
    public static void main(String[] args) {
        SyncDubbo1 syncDubbo1=new SyncDubbo1();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                syncDubbo1.method1();
            }
        });

        t1.start();
    }

    public synchronized void method1(){
        System.out.println("method1...");
        method2();
    }

    public synchronized void method2(){
        System.out.println("method2...");
        method3();
    }

    public synchronized void method3(){
        System.out.println("method3...");
    }
}
