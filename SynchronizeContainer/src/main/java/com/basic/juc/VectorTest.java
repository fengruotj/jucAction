package com.basic.juc;

import java.util.Iterator;
import java.util.Vector;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/5.
 *  java.util.ConcurrentModificationException

 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector=new Vector<>();

        for(int i=0;i<1000;i++){
            vector.add("tanjie"+i);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<String> iterator = vector.iterator();
                String str = null;
                while (iterator.hasNext()) {
                    str = iterator.next();
                    System.out.println(Thread.currentThread().getName() + ": " + str);
                }
            }
        }).start();

        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (!vector.isEmpty())
                            vector.remove(0);
                    }
                }
            }).start();
        }
    }
}
