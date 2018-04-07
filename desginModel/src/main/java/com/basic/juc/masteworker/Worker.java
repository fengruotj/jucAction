package com.basic.juc.masteworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * locate com.basic.juc.masteworker
 * Created by mastertj on 2018/4/6.
 */
public class Worker implements Runnable{
    private ConcurrentLinkedDeque<Task> workQueue=new ConcurrentLinkedDeque<>();
    private ConcurrentHashMap<String,Object> resultMap=new ConcurrentHashMap();

    public void setWorkQueue(ConcurrentLinkedDeque<Task> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (!workQueue.isEmpty()){
            Task poll = workQueue.poll();
            Object result = handle(poll);
            resultMap.put(String.valueOf(poll.getId()),result);
        }
    }

    public Object handle(Task input){
        Object object=null;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        object=input.getPrice();
        return object;
    }
}
