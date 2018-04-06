package com.basic.juc.model;

/**
 * locate com.basic.juc.model
 * Created by mastertj on 2018/4/6.
 */
public class Task implements Comparable<Task>{
    private int id;
    private String name;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
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
    public int compareTo(Task task) {
        //return this.id>task.id ? 1: (this.id<task.id? -1:0);
        return Integer.compare(this.id,task.id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
