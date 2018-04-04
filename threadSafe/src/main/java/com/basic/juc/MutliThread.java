package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 *  关键字synchronized取得的锁都是对象锁，而不是一段代码（方法）当作锁
 *  所以代码中哪个线程先执行synchronized关键字的方法，哪个线程持有该方法所属对象的锁（Lock）
 *
 * 在静态方法上加入synchronized关键字，表示锁定.class类，类一级别的锁（独占整个.class类）
 */
public class MutliThread {
    /** static **/
    private static int num=0;

    /** static **/
    public static synchronized void printNum(String tag){
        try {
            if(tag.equals("a")){
                num =100;
                System.out.println("tag a ,set num over!");
                Thread.sleep(1000);
            }else {
                num =200;
                System.out.println("tag b ,set num over!");
            }
            System.out.println("tag: "+tag+" num: "+num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final MutliThread m1=new MutliThread();
        final MutliThread m2=new MutliThread();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }
}
