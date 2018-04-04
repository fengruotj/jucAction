package com.basic.juc.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * locate com.basic.juc.volatileTest
 * Created by mastertj on 2018/4/4.
 * resutl::
 * 11865
 * 29558
 * 38697
 * 40929
 * 54676
 * 60000
 * 78701
 * 88710
 * 90000
 * 100000
 */
public class VolatileAtomic extends Thread{
    //private static volatile int count=0;
    private static AtomicInteger count=new AtomicInteger(0);

    public static void main(String[] args) {
        VolatileAtomic[] volatileNoAtomics=new VolatileAtomic[10];
        for(int i=0;i<10;i++){
            volatileNoAtomics[i]=new VolatileAtomic();
        }

        for(int i=0;i<10;i++){
            volatileNoAtomics[i].start();
        }

    }

    private void addCount(){
        for(int i=0;i<10000;i++){
            //count++;
            count.incrementAndGet();//count++
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        addCount();
    }
}
