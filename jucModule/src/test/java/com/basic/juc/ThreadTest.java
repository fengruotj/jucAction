package com.basic.juc;

/**
 * locate PACKAGE_NAME
 * Created by 79875 on 2017/10/18.
 * synchronized 四种用法
 * 1.修辞类
 * 2.修辞代码快
 * 3.修辞静态方法
 * 4.修辞方法体
 */
public class ThreadTest{
    public static void main(String[] args) {
        final ThreadSynchronized threadDemoA=new ThreadSynchronized();
        final ThreadSynchronized threadDemoB=new ThreadSynchronized();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    threadDemoA.A();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    threadDemoB.B();
            }
        }).start();
    }
}


class ThreadSynchronized{
    public ThreadSynchronized() {
    }

     public void A(){
         synchronized(ThreadDemo.class) {
             System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
         }
    }
    synchronized public void B() {
        synchronized (ThreadDemo.class) {
            System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        }
    }
}
