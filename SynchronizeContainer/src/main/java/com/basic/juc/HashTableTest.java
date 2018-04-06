package com.basic.juc;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/5.
 *  java.util.ConcurrentModificationException
 *  同步类容器是线程安全的（无非就是加锁）,复合类的操作如：迭代（反复访问元素，遍历完容器中的所有元素）、跳转（根据指定顺序找到当前元素的下一个元素）、以及条件运算。
 *  这些复合类操作在多线程中并发地修改容器时，就会造成java.util.ConcurrentModificationException 异常
 *
 *  多线程下的解决方案
 *  iterator遍历过程加同步锁，锁住整个arrayList
 */
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String,Integer> hashtable=new Hashtable<>();
        for(int i=0;i<1000;i++){
            hashtable.put("tanjie"+i,i);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (hashtable){
                    for (String str :hashtable.keySet()){
                        Integer value = hashtable.get(str);
                        System.out.println(Thread.currentThread().getName()+" key: "+str+" value: "+value);
                    }
                }
            }
        }).start();

        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (hashtable) {
                            Iterator<String> iterator = hashtable.keySet().iterator();
                            if(iterator.hasNext())
                                hashtable.remove(iterator.next());
                        }
                    }
                }
            }).start();
        }
    }
}
