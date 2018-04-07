package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/7.
 */
public class Task implements Runnable{
    private int id;
    private String name;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Task() {
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void run() {
        try {
            System.out.println("start Running.....");
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
