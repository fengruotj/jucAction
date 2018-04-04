package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * 锁对象的改变
 */
public class ChangeLock {
    private String lock="lock";

    public static void main(String[] args) {
        final ChangeLock changeLock=new ChangeLock();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        });

        t1.start();
        t2.start();
    }

    public void method(){
        try {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+" 开始");
                lock="change lock";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" 结束");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
