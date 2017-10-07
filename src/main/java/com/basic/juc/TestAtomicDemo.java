package com.basic.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/7.
 * 一. i++的原子性问题: i++的操作实际上分为三个步骤”读 写 改“
 *                int i=10;
 *                i=i++;//10
 *
 *                int temp=i;
 *                i=i+1;
 *                return temp;
 *
 * 二.原子变量：jdk1.5以后 java.util.concurrent.atomic 包下提供了常用的原子变量
 *              1.volatile 保证内存可见性
 *              2.CAS(Compare-And-Swap) 算法保证数据的原子性
 *               CAS算法是硬件对于并发操作共享数据的支持
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo=new AtomicDemo();
        for(int i=0;i<10;i++){
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable{

    private AtomicInteger serialNumber=new AtomicInteger(0);
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }
}
