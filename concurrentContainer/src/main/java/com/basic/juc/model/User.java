package com.basic.juc.model;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * locate com.basic.juc.model
 * Created by mastertj on 2018/4/6.
 */
public class User implements Delayed{
    //用户id
    private int id;
    //用户名
    private String name;
    //下机时间
    private Long endTime;

    private TimeUnit timeUnit=TimeUnit.SECONDS;

    public User(int id, String name, Long endTime) {
        this.id = id;
        this.name = name;
        this.endTime = endTime;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", endTime=" + endTime +
                '}';
    }

    /**
     * 用来判断是否到了截至时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return endTime-System.currentTimeMillis();
    }

    /**
     * 相互比较排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        User user =(User)o;
        return Long.compare(this.getDelay(timeUnit),o.getDelay(timeUnit));
    }
}
