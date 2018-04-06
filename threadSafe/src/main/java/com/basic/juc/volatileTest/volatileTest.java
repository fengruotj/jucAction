package com.basic.juc.volatileTest;

/**
 * locate com.basic.juc.volatileTest
 * Created by mastertj on 2018/4/6.
 */
public class volatileTest {
    public boolean m_bool=false;

    public static void main(String[] args) {
        volatileTest volatileTest=new volatileTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    volatileTest.m_bool=true;
                    System.out.println(volatileTest.m_bool);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(800);
                        System.out.println(volatileTest.m_bool);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
