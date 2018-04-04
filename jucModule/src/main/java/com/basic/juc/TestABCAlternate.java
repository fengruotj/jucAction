package com.basic.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/8.
 * 编写一个程序，开启三个线程，这三个线程的ID分别是A.B.C 每个线程都有自己的ID 在屏幕上打印20遍，要求输出的结果必须按顺序显示。
 *  如：ABCABCABC交替执行
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        final AlternateDemo alternateDemo=new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    alternateDemo.loopA(i);
            }
        },"A线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    alternateDemo.loopB(i);
            }
        },"B线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    alternateDemo.loopC(i);
            }
        },"C线程").start();
    }
}

class AlternateDemo{
    private int number=1;//当前正在执行线程的标记

    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void loopA(int totalLoop){
        lock.lock();
        try {
           //1.判断
            if(number!=1){
                condition1.await();
            }

            //2.打印
            for(int i=0;i<1;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }

            //3.唤醒其他线程
            number=2;
            condition2.signal();//只唤醒一个线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void loopB(int totalLoop){
        lock.lock();
        try {
            //1.判断
            if(number!=2){
                condition2.await();
            }

            //2.打印
            for(int i=0;i<1;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }

            //3.唤醒其他线程
            number=3;
            condition3.signal();//只唤醒一个线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void loopC(int totalLoop){
        lock.lock();
        try {
            //1.判断
            if(number!=3){
                condition3.await();
            }

            //2.打印
            for(int i=0;i<1;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }

            //3.唤醒其他线程
            number=1;
            condition1.signal();//只唤醒一个线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
