package com.basic.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/8.
 * 一。用于解决多线程安全问题的方式
 *
 * synchorized关键字
 * 1.同步代码块
 *
 * 2.同步方法
 *
 * jdk1.5以后
 * 3.同步锁 Lock
 * 注意：是一个显示锁，需要通过lock()方法进行上锁，必须通过unlock方法()进行释放锁
 */
public class TestLock {
    public static void main(String[] args) {
        LockDemo lockDemo=new LockDemo();

        new Thread(lockDemo,"1号窗口").start();
        new Thread(lockDemo,"2号窗口").start();
        new Thread(lockDemo,"3号窗口").start();
    }
}

class LockDemo implements Runnable{
    private int tick=100;

    private Lock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if (tick>0) {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ":" + " 完成售票，余票为：" + --tick);
                }else break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
