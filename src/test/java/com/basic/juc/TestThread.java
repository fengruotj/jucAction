package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/9.
 */
public class TestThread {

    public static void main(String[] args) {
        new Thread(new ThreadTestDemo()).start();

        System.out.println("------------a--------------");
    }
}

class ThreadTestDemo implements Runnable{

    private long startTime=System.currentTimeMillis();

    @Override
    public void run() {
//        while (true){
//            long endTime=System.currentTimeMillis();
//            if((endTime-startTime)>=5000){
//                break;
//            }
//        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
