package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/8.
 * 生产者消费者案列
 * 多线程等待唤醒机制
 */
public class TestProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Productor productor=new Productor(clerk);
        Consumer consumer=new Consumer(clerk);

        new Thread(productor,"生产者A").start();
        new Thread(consumer,"消费者B").start();
    }
}

//店员
//防止产生多线程安全问题
//class Clerk{
//    private int product=0;
//
//    //进货
//    public synchronized void get(){
//        while(product>=10){//为了避免虚假唤醒的问题，应该总是在循环中
//            System.out.println("产品已满！");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName()+" : "+ ++product);
//        this.notifyAll();
//    }
//
//    //卖货
//    public synchronized void sale() {
//        while(product<=0){//为了避免虚假唤醒的问题，应该总是在循环中
//            System.out.println("缺货！");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName()+" : "+--product);
//        this.notifyAll();
//    }
//}

//生产者
class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            clerk.get();
        }
    }
}

//消费者
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            clerk.sale();
        }
    }
}
