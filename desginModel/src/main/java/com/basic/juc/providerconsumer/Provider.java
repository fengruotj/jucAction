package com.basic.juc.providerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * locate com.basic.juc.providerconsumer
 * Created by mastertj on 2018/4/7.
 */
public class Provider implements Runnable{
    private static Random random=new Random();
    //共享缓存区
    private BlockingDeque<Data> blockingDeque;
    //多线程是否启动变量，有强制从内存缓冲区中刷新的功能，即时返回线程的状态
    private volatile boolean isRunning=true;
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public Provider(BlockingDeque<Data> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        while (isRunning){
            try {
                atomicInteger.incrementAndGet();
                Data data=new Data(atomicInteger.get(),"数据"+atomicInteger.get());
                Thread.sleep(200);
                System.out.println("当前线程"+Thread.currentThread().getName()+"生产了数据： id: "+data.getId()+" name: "+data.getName());
                if(!blockingDeque.offer(data,3, TimeUnit.SECONDS)){
                    System.out.println(data+" 添加入数据缓冲区失败");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        isRunning=false;
    }
}
