package com.basic.juc.masteworker;

/**
 * locate com.basic.juc.masteworker
 * Created by mastertj on 2018/4/6.
 */
public class Task {
    private int id;
    private int Price;

    public Task(int id, int price) {
        this.id = id;
        Price = price;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", Price=" + Price +
                '}';
    }
}
