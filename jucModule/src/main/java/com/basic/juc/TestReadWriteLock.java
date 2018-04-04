package com.basic.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/9.
 * 1.ReadWriteLock :读写锁
 *
 * 写写/读写 需要“互斥”
 * 读读  不需要“互斥”
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        final ReadWriteLockDemo writeLockDemo=new ReadWriteLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                writeLockDemo.write((int)(Math.random() * 101));
            }
        },"写操作").start();

        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    writeLockDemo.get();
                }
            }).start();
        }
    }
}

class ReadWriteLockDemo{
    private  int number=0;

    private ReadWriteLock lock=new ReentrantReadWriteLock();

    //读取操作
    public void get(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" : "+number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    //写数据操作
    public void write(int number){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number=number;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
