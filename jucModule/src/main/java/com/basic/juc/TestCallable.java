package com.basic.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/8.
 * 创建执行线程的第三种方式：实现Callable接口
 * 一。相较于实现 Runable 的方式 接口的方式，方法可以有返回值，并且可以抛出异常。
 *
 * 二。执行Callable的方式，需要FutureTask实现类的支持，用于接受运算结果。FutureTask 是 Future接口的实现类。
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo=new CallableDemo();

        //1.执行 Callable 的方式 需要 FutureTask 实现类的支持，用于接收运算结果
        FutureTask<Integer> result=new FutureTask<Integer>(callableDemo);//FutureTask 也可以用于闭锁

        new Thread(result).start();

        //2.接受线程运算后的结果
        Integer integer = result.get();
        System.out.println("sum: "+integer);
    }
}

class CallableDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i=0;i<100;i++){
            sum+=i;
        }
        System.out.println("callable:"+sum);
        return sum;
    }
}
