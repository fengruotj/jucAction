package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 */
public class MyRunThread {
    /**volatile**/
    //使变量在多个线程中可见
    private volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
        MyRunThread rt=new MyRunThread();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                rt.run();
            }
        });
        t1.start();

        Thread.sleep(3000);

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rt.setRunning(false);
                    System.out.println("isRunning的值 被设置为false");
                    Thread.sleep(1000);
                    System.out.println(rt.isRunning);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();
    }

    private void setRunning(boolean isRunning){
        this.isRunning=isRunning;
    }

    public void run() {
        System.out.println("进入 run 方法.....");
        while (isRunning == true){

        }
        System.out.println("线程终止");
    }
}
