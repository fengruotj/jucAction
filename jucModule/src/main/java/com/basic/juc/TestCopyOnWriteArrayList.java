package com.basic.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/7.
 * CopyOnWriteArrayList 写入并且复制
 * 每次写入数据 都复制一份新的List 让数据添加到新的List中。然后将新的List添加到原来的ArrayList
 * 添加操作多的时候效率会很低。因为每次添加时都会进行一次复制操作，开销会很大。并发迭代操作多的时候可以选择，可以提高效率
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HelloThread helloThread=new HelloThread();
        for(int i=0;i<10;i++){
            new Thread(helloThread).start();
        }
    }
}

class HelloThread implements Runnable{

//    private static List<String> list= Collections.synchronizedList(new ArrayList<String>());

    private static CopyOnWriteArrayList list=new CopyOnWriteArrayList();

    static {
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
    }
    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            list.add("tanjie");
        }
    }
}
