package com.basic.juc.volatileTest;

/**
 * locate com.basic.juc.volatileTest
 * Created by mastertj on 2018/4/4.
 * volatile 关键字不具备synchronized关键字的同步（原子性）
 * resutl::
 * 10504
 * 20850
 * 29726
 * 42940
 * 43619
 * 43569
 * 57450
 * 61125
 * 58937
 * 71125
 */
public class VolatileNoAtomic extends Thread{
    private static volatile int count=0;

    public static void main(String[] args) {
        VolatileNoAtomic[] volatileNoAtomics=new VolatileNoAtomic[10];
        for(int i=0;i<10;i++){
            volatileNoAtomics[i]=new VolatileNoAtomic();
        }

        for(int i=0;i<10;i++){
            volatileNoAtomics[i].start();
        }

    }

    //private static AtomicInteger count=new AtomicInteger(0);
    private void addCount(){
        for(int i=0;i<10000;i++){
            count++;
            //count.incrementAndGet();//count++
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        addCount();
    }
}
