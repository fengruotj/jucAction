package com.basic.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 */
public class ListAdd1 {
    //volatile
    private volatile static List list=new ArrayList();

    public static void main(String[] args) throws InterruptedException {

        ListAdd1 listAdd1=new ListAdd1();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<10;i++){
                        listAdd1.addList();
                        System.out.println(Thread.currentThread().getName()+" 添加了一个元素");
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(list.size()==5){
                        System.out.println("当前线程收到通知"+Thread.currentThread().getName()+" list size=5 线程停止");
                        throw new RuntimeException();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    public void addList(){
        list.add("tanjie");
    }

    public int size(){
        return list.size();
    }
}
