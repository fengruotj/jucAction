package com.basic.juc;

import com.basic.juc.forkjoin.ForkJoinSumCalculate;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/9.
 */
public class TestForkJoinPool {

    /**
     * ForkJoin 框架计算大数累加
     */
    @Test
    public void Test1(){
        Instant start=Instant.now();
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinSumCalculate(0L,10000000000L);
        Long invoke = forkJoinPool.invoke(task);
        System.out.println(invoke);
        Instant end=Instant.now();
        System.out.println("Duration Time: "+ Duration.between(start,end).toMillis());//2330
    }

    /**
     * For 循环 计算大数累加
     */
    @Test
    public void Test2(){
        Instant start=Instant.now();
        long sum=0;
        for(long i=0;i<=10000000000L;i++){
            sum+=i;
        }
        System.out.println(sum);
        Instant end=Instant.now();
        System.out.println("Duration Time: "+ Duration.between(start,end).toMillis());//3245
    }

    /**
     * Java8 新特性
     */
    @Test
    public void Test3(){
        Instant start=Instant.now();
        Long sum= LongStream.rangeClosed(0,10000000000L).parallel().reduce(0L,Long ::sum);
        System.out.println(sum);
        Instant end=Instant.now();
        System.out.println("Duration Time: "+ Duration.between(start,end).toMillis());//2169
    }
}
