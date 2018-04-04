package com.basic.juc.lock;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 */
public class ObjectLock {
    final Object lock=new Object();

    public void method1(){
        synchronized (this){    //对象锁
            try {
                System.out.println("do method1......");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method2(){
        synchronized (ObjectLock.class){    //类锁
            try {
                System.out.println("do method1......");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method3(){
        synchronized (lock){    //任何对象锁
            try {
                System.out.println("do method1......");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
