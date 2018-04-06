package com.basic.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/6.
 *
 * 阻塞队列
 */
public class UseArryayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        //基于数组的阻塞队列，在ArrayBlockingQueue内部维护着一个定长数组
        ArrayBlockingQueue<Integer> arrayBlockingQueue=new ArrayBlockingQueue<Integer>(5);
        arrayBlockingQueue.add(1);
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(3);
        arrayBlockingQueue.add(4);
        arrayBlockingQueue.add(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    arrayBlockingQueue.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        boolean result=arrayBlockingQueue.offer(6, 10,TimeUnit.SECONDS);

        System.out.println("result: "+result);
    }
}
