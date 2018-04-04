package com.basic.juc.lock;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * 死锁问题，在设计程序的时候就应该避免对方相会持有对方的锁
 */
public class DeadLock {
    private String tag;
    private Object lock1=new Object();
    private Object lock2=new Object();

    public static void main(String[] args) {
        final DeadLock deadLock=new DeadLock();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.setTag("a");
                deadLock.run();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.setTag("b");
                deadLock.run();
            }
        });

        t1.start();

        t2.start();
    }

    public void setTag(String tag){
        this.tag=tag;
    }

    public void run(){
        if(tag.equals("a")){
            synchronized (lock1){
                try {
                    System.out.println(Thread.currentThread().getName()+" 进入lock1....");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+" 进入lock2....");
                }
            }
        }

        if(tag.equals("b")){
            synchronized (lock2){
                try {
                    System.out.println(Thread.currentThread().getName()+" 进入lock2....");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+" 进入lock1....");
                }
            }
        }
    }
}
