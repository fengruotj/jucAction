package com.basic.juc;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/8.
 */
public class CASThread implements Runnable{
    private AtomicInteger count=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CASThread casThread=new CASThread();
        ExecutorService executorService= Executors.newCachedThreadPool();

        for(int i=0;i<5;i++){
            executorService.execute(new Thread(casThread));
        }

        executorService.shutdown();
        executorService.awaitTermination(200, TimeUnit.SECONDS);
        System.out.println(casThread.count.get());
    }

    @Override
    public void run() {
        while (count.get()<2000){
            Integer current=count.get();
            Integer next=current+1;
            boolean b = count.compareAndSet(current, next);
            if(b){
                System.out.println(new Date()+" now count: "+count.get());
            }
        }
    }
}
