package com.basic.juc.volatileTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * locate com.basic.juc.volatileTest
 * Created by mastertj on 2018/4/4.
 * volatile 关键字只具有可见性，不具备原子性。要实现原子性建议使用atomic类的原始对象，支持原子性操作（注意atomic类只保证本身方法的原子性，并不保持多次操作的原子性）
 */
public class AtomicUse {

    private AtomicInteger count=new AtomicInteger(0);

    public static void main(String[] args) {
        AtomicUse atomicUse=new AtomicUse();
        List<Thread> threadList=new ArrayList<>();
        for(int i=0;i<100;i++){
            threadList.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(atomicUse.mulitAdd());
                }
            }));
        }

        for(int i=0;i<100;i++){
            threadList.get(i).start();
        }
    }

    //多个addAndGet在一个方法内是原子性的，需要加synchronized进行修饰，保证4个addAndGet具备原子性
    //synchronized
    public int mulitAdd(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.addAndGet(1);
        count.addAndGet(2);
        count.addAndGet(3);
        count.addAndGet(4);//+10
        return count.get();
    }
}
