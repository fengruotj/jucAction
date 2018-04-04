package com.basic.juc;

import java.util.concurrent.CountDownLatch;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/8.
 * 闭锁操作 CountDownLatch：闭锁，在完成某些运算时，只有其他所有线程都完成时，当前运算才继续执行
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch=new CountDownLatch(10);
        LatchDemo latchDemo=new LatchDemo(countDownLatch);

        long startTime=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            new Thread(latchDemo).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("耗费时间为:"+(endTime-startTime));
    }
}

class LatchDemo implements Runnable{
    private CountDownLatch countDownLatch;

    public LatchDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                for(int i=0;i<50000;i++){
                    if(i%2==0)
                        System.out.println(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                countDownLatch.countDown();
            }
        }
    }
}
