package com.basic.juc;

import java.util.concurrent.SynchronousQueue;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/6.
 */
public class UseSynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        //一种没有缓冲的Queue，生产者生产的数据会被消费者直接消费
        final SynchronousQueue<Integer> synchronousQueue=new SynchronousQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入到t1线程中阻塞等待");
                    System.out.println("消费："+synchronousQueue.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(5000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronousQueue.add(5);
            }
        }).start();
    }
}
