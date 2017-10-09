package com.basic.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * locate com.basic.juc.forkjoin
 * Created by 79875 on 2017/10/9.
 */
public class TestForkJoinPool {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinSumCalculate(0L,1000000L);
        Long invoke = forkJoinPool.invoke(task);
        System.out.println(invoke);
    }
}



