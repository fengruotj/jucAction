package com.basic.juc;

import com.basic.juc.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/6.
 * 基于优先级的阻塞队列（优先级的判断通过构造函数传入的Compator对象来决定，也就是说传入队列的对象必须实现Comparable接口），在实现PriorityBlockingQueue时，
 * 内部控制线程同步的锁采用的时公平锁，他是一个无界的队列
 */
public class UsePriorityBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Task> priorityQueue=new PriorityBlockingQueue<>();
        List<Task> list=new ArrayList<>();
        Task task1=new Task(1,"1");
        Task task3=new Task(3,"3");
        Task task2=new Task(2,"2");

        priorityQueue.add(task1);
        priorityQueue.add(task2);
        priorityQueue.add(task3);

        list.add(task3);
        list.add(task2);
        list.add(task1);

        Collections.sort(list);
        System.out.println(list);
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.take());
            System.out.println(priorityQueue);
        }
    }
}
