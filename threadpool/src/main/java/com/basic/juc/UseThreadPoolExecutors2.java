package com.basic.juc;

import java.util.concurrent.*;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/7.
 */
public class UseThreadPoolExecutors2 {
    public static void main(String[] args) {
        final LinkedBlockingDeque blockingDeque = new LinkedBlockingDeque<Task>();

        /**
         * 无界的任务队列时：LinkedBlockingDeque
         * 与有界队列相比，除非系统资源耗尽，否则无界的任务队列不存在入队失败的情况
         * 当由新任务到来的时候，系统线程数量小于corePoolSize的时候，则新建线程执行任务
         * 当达到corePoolSize后们就不会集训增加，若后续仍有新的任务加入，而没有空闲的线程资源，则任务直接进入队列等待
         * 若任务创建和处理的速度差异很大，无界队列则会保持快速增长，直到耗尽系统内存
         */
        final ExecutorService executorService = new ThreadPoolExecutor(5, 5, 120L, TimeUnit.SECONDS, blockingDeque);

        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task(i, "task" + i));
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!executorService.isTerminated()) {
                        Thread.sleep(500);
                        System.out.println("Queue Size: " + blockingDeque.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        executorService.shutdown();
    }
}
