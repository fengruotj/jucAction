package com.basic.juc.forkjoin;

/**
 * locate com.basic.juc.forkjoin
 * Created by 79875 on 2017/10/9.
 * 利用ForkJoin框架 测试结果查看测试用例
 * 题目计算：1+2+3+。。。。。+ 10000000000L
 */

import java.util.concurrent.RecursiveTask;

/**
 * 递归 Recursive
 */
public class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private static final long THURSHOLD=10000L; //零界值
    private long start;
    private long end;

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length=end-start;

        if(length<=THURSHOLD){
            long sum =0L;
            for(long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else {
            long middle=(start+end)/2;
            ForkJoinSumCalculate left=new ForkJoinSumCalculate(start,middle);
            left.fork();//进行拆分，同时压入线程队列

            ForkJoinSumCalculate right=new ForkJoinSumCalculate(middle+1,end);
            right.fork();//进行拆分，同时压入线程队列

            return left.join()+right.join();
        }
    }
}
