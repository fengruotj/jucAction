package com.basic.juc;

import java.util.concurrent.*;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/7.
 */
public class UserExecutors {
    public static void main(String[] args) {
        //创建一个线程的线程池
        ExecutorService service1= Executors.newSingleThreadExecutor();

        //创建一个固定大小的线程池
        ExecutorService service2= Executors.newFixedThreadPool(10);

        //创建一个根据实际情况调整线程数量的线程池
        ExecutorService service3= Executors.newCachedThreadPool();

        ExecutorService service4= Executors.newScheduledThreadPool(5);
        service4.shutdown();
        //
        new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
}
