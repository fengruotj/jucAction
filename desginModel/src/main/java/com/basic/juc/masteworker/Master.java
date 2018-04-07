package com.basic.juc.masteworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * locate com.basic.juc.masteworker
 * Created by mastertj on 2018/4/6.
 */
public class Master {
    //1.有一个盛放任务的容器
    private ConcurrentLinkedDeque<Task> workQueue=new ConcurrentLinkedDeque<>();
    //2.需要一个盛放worker的容器
    private HashMap<String,Thread> workers=new HashMap<>();

    //3.需要一个盛放每一个worker执行任务的结果集合
    private ConcurrentHashMap<String,Object> resultMap=new ConcurrentHashMap();

    //4.构造方法
    public Master(Worker worker,int workercount){
        worker.setResultMap(resultMap);
        worker.setWorkQueue(workQueue);
        for(int i=0;i<workercount;i++){
            workers.put(String.valueOf(i),new Thread(worker));
        }
    }

    //5.需要一提交任务的方法
    public void submit(Task task){
        workQueue.add(task);
    }

    //6.需要一执行的方法，启动所有的workers去执行任务
    public void execute(){
        for (Map.Entry<String, Thread> entry : workers.entrySet()) {
            entry.getValue().start();
        }
    }

    //7.判断是否运行结束的方法
    public boolean isComplete(){
        for (Map.Entry<String, Thread> entry : workers.entrySet()) {
            if(entry.getValue().getState()!=Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    //8.计算结果的方法
    public int getResult(){
        int result=0;
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            result+=(int)entry.getValue();
        }
        return result;
    }
}
