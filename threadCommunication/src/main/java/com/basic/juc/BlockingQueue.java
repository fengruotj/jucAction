package com.basic.juc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * BlockingQueue :顾名思义，首先它是一个队列，并且支持阻塞的机制，阻塞的放入和得到数据，我们要实现LinkedBlockingQueue下面两个简单的方法put和take
 * put(an Object):把an Object 加到BlockingQueue里面，如果BlockingQueue没有空间，则调用此方法的线程被阻塞，知道BlockingQueue中有空间才加入进去
 * take:取走 BlockingQueue排到首位的对象，若BlockingQueue为空，阻塞进入等待状态，直到BlockingQueue中又数据为止
 */
public class BlockingQueue {
    //设置容器的上限和下限
    private final int minsize=0;
    private final int maxsize;
    //
    private List<Object> list=new LinkedList<>();
    //需要一个计数器
    private AtomicInteger count=new AtomicInteger(0);
    //初始化一个锁 用于加锁
    private Object lock=new Object();

    //构造方法
    public BlockingQueue(int maxsize) {
        this.maxsize = maxsize;
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue=new BlockingQueue(5);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        blockingQueue.put("d");
        blockingQueue.put("e");

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                blockingQueue.put("f");
                blockingQueue.put("g");
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                Object take1 = blockingQueue.take();
                Object take = blockingQueue.take();
                System.out.println(take+" "+take1);
            }
        });

        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    public void put(Object obj){
        synchronized (lock){
            while (count.get()==this.maxsize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //1.添加元素操作
            list.add(obj);
            //2.计数器加一
            count.incrementAndGet();
            //3.唤醒另一个线程
            lock.notify();
            System.out.println("新加入的元素: "+obj);
        }
    }

    public Object take(){
        Object res=null;
        synchronized (lock){
            while (count.get()==this.minsize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //1.移除元素操作
            res = list.remove(0);
            //2.计数器减一
            count.decrementAndGet();
            //3.唤醒另一个线程
            lock.notify();
        }
        return res;
    }
}
