package com.basic.juc.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * locate com.basic.juc.threadpool
 * Created by 79875 on 2017/10/9.
 *  * 一。线程池：提供了一个线程队列，队列中保存者所有等待状态的线程。避免了创建与销毁的额外开销，因此提高了响应的速度。
 *
 * 二。线程池的体系结构：
 *  java.util.concurrent.Executor ：负责线程的使用与调度的接口
 *          |--ExucutorService 子接口：线程池的只要接口
 *              |--ThreadPoolExecutor 线程池实现类
 *              |--ScheduleExecutorServiec 子接口：负责线程调度的子接口
 *                  |--ScheduleThreadPoolExecutor （extends 线程池实现类，实现了ScheduleExecutroSercie子接口）
 */
public class TestScheduleThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService pool= Executors.newScheduledThreadPool(5);
        List<Future<Integer>> futureList=new ArrayList<>();
        for(int i=0;i<10;i++) {
            Future<Integer> future = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println(Thread.currentThread().getName() + " " + (int) (Math.random() * 101));
                    return 1;
                }
            }, 2000, TimeUnit.MILLISECONDS);
            futureList.add(future);
        }

        try {
            for(Future<Integer> futureTask: futureList){
                Integer integer = futureTask.get();
                System.out.println("result: "+integer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
        pool.shutdown();
    }
}
