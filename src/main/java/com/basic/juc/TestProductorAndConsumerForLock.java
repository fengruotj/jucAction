package com.basic.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/8.
 * 生产者消费者案列
 * 多线程等待唤醒机制
 */
public class TestProductorAndConsumerForLock {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Productor productor=new Productor(clerk);
        Consumer consumer=new Consumer(clerk);

        new Thread(productor,"生产者A").start();
        new Thread(consumer,"消费者B").start();
    }
}

//店员
//防止产生多线程安全问题
class Clerk{
    private int product=0;

    private Lock lock=new ReentrantLock();

    private Condition condition=lock.newCondition();

    //进货
    public void get(){
        lock.lock();
        try {
            while(product>=10){//为了避免虚假唤醒的问题，应该总是在循环中
                System.out.println("产品已满！");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+" : "+ ++product);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //卖货
    public void sale() {
        lock.lock();
        try {
            while(product<=0){//为了避免虚假唤醒的问题，应该总是在循环中
                System.out.println("缺货！");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+" : "+--product);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
