package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/7.
 * 模拟CAS算法 原子性操作
 */
public class TestCompareAndSwap {
    public static void main(String[] args) {
        final CompareAndSwap compareAndSwap=new CompareAndSwap();
        for(int i=0;i<20;i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int exepctvaule = compareAndSwap.get();
                    boolean b=compareAndSwap.compareAndSet(exepctvaule,(int)(Math.random()*101));
                    System.out.println(b);
                }
            }).start();
    }
}

class CompareAndSwap{
    private int value;

    /**
     * 获取内存值
     * @return
     */
    public  synchronized  int get(){
        return value;
    }

    /**
     * 比较
     * @param expectValue
     * @param newVaule
     * @return
     */
    public synchronized int compareAndSwap(int expectValue, int newVaule){
        int oldValue=value;
        if(oldValue==expectValue){
            value=newVaule;
        }
        return oldValue;
    }

    /**
     * 设置
     * @param expectValue
     * @param newVaule
     * @return
     */
    public synchronized boolean compareAndSet(int expectValue, int newVaule){
        return expectValue == compareAndSwap(expectValue,newVaule);
    }
}
