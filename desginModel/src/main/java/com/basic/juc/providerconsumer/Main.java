package com.basic.juc.providerconsumer;

import java.util.concurrent.*;

/**
 * locate com.basic.juc.providerconsumer
 * Created by mastertj on 2018/4/7.
 */
public class Main {
    public static void main(String[] args) {
        BlockingDeque blockingDeque=new LinkedBlockingDeque(10);
        Provider p1=new Provider(blockingDeque);
        Provider p2=new Provider(blockingDeque);
        Provider p3=new Provider(blockingDeque);

        Consumer c1=new Consumer(blockingDeque);
        Consumer c2=new Consumer(blockingDeque);
        Consumer c3=new Consumer(blockingDeque);

        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);
        executorService.execute(c1);
        executorService.execute(c2);
        executorService.execute(c3);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        p1.stop();
        p2.stop();
        p3.stop();

        executorService.shutdown();
    }
}
