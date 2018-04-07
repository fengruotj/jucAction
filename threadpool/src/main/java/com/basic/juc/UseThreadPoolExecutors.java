package com.basic.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/7.
 */
public class UseThreadPoolExecutors {
    public static void main(String[] args) {
        final ArrayBlockingQueue blockingDeque=new ArrayBlockingQueue<Task>(3);

        /**
         * 在使用有界队列的时候，若有新的任务执行的时候，如果线程池的实际线程数量小于corePoolSize，则优先创建线程
         * 若大于corePoolSize的时候，则会讲任务加入线程队列中去
         * 若队列任务数量满的时候，则在总线程不大于maximumPoolSize的前提下，创建新的线程
         * 若线程数量大于maximumPoolSize的时候，则执行拒绝策略，可以指定其自定义方式
         */
        final ExecutorService executorService=new ThreadPoolExecutor(1,2,120L, TimeUnit.SECONDS,blockingDeque);

        executorService.execute(new Task(1,"task1"));
        executorService.execute(new Task(2,"task2"));
        executorService.execute(new Task(3,"task3"));
        executorService.execute(new Task(4,"task4"));
        executorService.execute(new Task(5,"task5"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!executorService.isTerminated()){
                        Thread.sleep(500);
                        System.out.println("Queue Size: "+blockingDeque.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        executorService.shutdown();
    }
}
