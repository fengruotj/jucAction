package com.basic.juc.providerconsumer;

import java.util.concurrent.BlockingDeque;

/**
 * locate com.basic.juc.providerconsumer
 * Created by mastertj on 2018/4/7.
 */
public class Consumer implements Runnable{
    //共享缓存区
    private BlockingDeque<Data> blockingDeque;

    public Consumer(BlockingDeque<Data> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        while (true){
            try {
                Data data = blockingDeque.take();
                //进行数据处理，消费者消费数据耗时0.1s
                Thread.sleep(100);
                if(data!=null)
                    System.out.println("当前线程"+Thread.currentThread().getName()+"消费了数据： id: "+data.getId()+" name: "+data.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
