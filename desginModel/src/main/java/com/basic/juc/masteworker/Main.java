package com.basic.juc.masteworker;

import java.util.Random;

/**
 * locate com.basic.juc.masteworker
 * Created by mastertj on 2018/4/6.
 */
public class Main {
    public static void main(String[] args) {
        Master master=new Master(new Worker(),20);

        Random random=new Random();
        for(int i=0;i<100;i++){
            Task task=new Task(i, random.nextInt(1000));
            master.submit(task);
        }

        master.execute();
        long startTimeMills=System.currentTimeMillis();

        while (true){
            if(master.isComplete()){
                long endTimeMills=System.currentTimeMillis();
                int result = master.getResult();
                System.out.println("运算结果是: "+result+" 运算时间: "+(endTimeMills-startTimeMills));
                break;
            }
        }
    }
}
