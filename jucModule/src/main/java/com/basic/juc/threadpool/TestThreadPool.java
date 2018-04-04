package com.basic.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * locate com.basic.juc.threadpool
 * Created by 79875 on 2017/10/9.
 * 一。线程池：提供了一个线程队列，队列中保存者所有等待状态的线程。避免了创建与销毁的额外开销，因此提高了响应的速度。
 *
 * 二。线程池的体系结构：
 *  java.util.concurrent.Executor ：负责线程的使用与调度的接口
 *          |--ExucutorService 子接口：线程池的只要接口
 *              |--ThreadPoolExecutor 线程池实现类
 *              |--ScheduleExecutorServiec 子接口：负责线程调度的子接口
 *                  |--ScheduleThreadPoolExecutor （extends 线程池实现类，实现了ScheduleExecutroSercie子接口）
 */
public class TestThreadPool {
    public static void main(String[] args) {

        ThreadPoolDemo threadPoolDemo=new ThreadPoolDemo();
        //1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        //2.为线程池中的线程分配任务
        for(int i=0;i<10;i++)
            pool.submit(threadPoolDemo);

        //3.关闭线程池
        pool.shutdown();
    }
}

class ThreadPoolDemo implements Runnable{

    private int i=0;
    @Override
    public void run() {
       while (i<=100)
           System.out.println(Thread.currentThread().getName()+" : "+i++);
    }
}
