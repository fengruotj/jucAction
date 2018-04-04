package com.basic.juc.volatileTest;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 */
public class RunThread extends Thread {
    /**volatile**/
    //使变量在多个线程中可见
    private volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
        RunThread rt=new RunThread();
        rt.start();

        Thread.sleep(3000);
        rt.setRunning(false);
        System.out.println("isRunning的值 被设置为false");
        Thread.sleep(1000);
        System.out.println(rt.isRunning);
    }

    private void setRunning(boolean isRunning){
        this.isRunning=isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入 run 方法.....");
        while (isRunning == true){

        }
        System.out.println("线程终止");
    }
}
