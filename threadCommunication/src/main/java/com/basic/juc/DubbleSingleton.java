package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * 单列模式
 */
public class DubbleSingleton {
    private static DubbleSingleton dubbleSingleton;

    public static DubbleSingleton getDs(){
        if(dubbleSingleton==null){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (DubbleSingleton.class){
                if(dubbleSingleton==null){
                    dubbleSingleton=new DubbleSingleton();
                }
            }
        }
        return dubbleSingleton;
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getDs().hashCode());
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getDs().hashCode());
            }
        });

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getDs().hashCode());
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
