package com.basic.juc;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/7.
 */
public class MyReject implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义处理");
        System.out.println("当前被拒绝任务为："+r.toString());
    }
}
