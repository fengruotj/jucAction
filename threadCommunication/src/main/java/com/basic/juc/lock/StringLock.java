package com.basic.juc.lock;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.'
 * synchronized 代码块对字符串的锁，注意String常量池的缓冲功能
 */
public class StringLock {
    public void method(){
        synchronized (new String("字符串常量")){
            try {
                while (true){
                    System.out.println(Thread.currentThread().getName()+" 开始");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+" 结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
