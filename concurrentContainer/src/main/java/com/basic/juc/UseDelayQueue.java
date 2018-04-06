package com.basic.juc;

import com.basic.juc.model.InternetBar;

import java.util.Random;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/6.
 * 带有延迟时间的Queue，其中的元素只有当其指定的延迟时间到了，才能从队列中获取到该元素。delayQueue中的元素必须实现delayed接口，
 * DelayQueue是一个大小没有限制的队列，应用场景很多，比如对缓存超时的数据进行移除、任务超时处理、空闲连接的关闭等等
 */
public class UseDelayQueue {

    public static void main(String[] args) {
        //网吧上网模型
        InternetBar internetBar=new InternetBar();
        internetBar.setStart(true);
        internetBar.start();

        Random random=new Random();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    internetBar.startInterent(i,"tanjie"+i,random.nextInt(10));
                }
                System.out.println(internetBar.isStart());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    internetBar.setStart(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
