package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * ThreadLocal 线程局部概念，是一种多线程间并发访问变量的解决方案。与其synchronized等加锁方式不同，ThreadLocal完全不提供任何锁，而使用换时间的手段，
 * 为每个线程提供变量的独立副本，以保证线程安全
 */
public class ConnThreadLocal {
    ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {
        final ConnThreadLocal connThreadLocal=new ConnThreadLocal();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    connThreadLocal.setValue("tanjie");
                    System.out.println(connThreadLocal.getValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(connThreadLocal.getValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        t2.start();
    }

    public String getValue(){
        return threadLocal.get();
    }

    public void setValue(String vaule){
        threadLocal.set(vaule);
    }
}
