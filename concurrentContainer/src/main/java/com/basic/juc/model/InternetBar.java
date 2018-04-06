package com.basic.juc.model;

import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * locate com.basic.juc.model
 * Created by mastertj on 2018/4/6.
 */
public class InternetBar extends Thread{
    public DelayQueue<User> delayQueue=new DelayQueue<>();

    private volatile boolean isStart=false;

    public void startInterent(Integer id ,String name,Integer money){
        User user=new User(id,name,Long.valueOf(1000*money+System.currentTimeMillis()));
        delayQueue.add(user);
    }

    public void endInternet(User user){
        System.out.println(new Date().toString()+" 用户: "+user.getName()+" 下机");
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    @Override
    public void run() {
        try {
            while (isStart){
                User user = delayQueue.take();
                endInternet(user);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
