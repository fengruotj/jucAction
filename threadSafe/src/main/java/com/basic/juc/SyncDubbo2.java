package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * 父类和子类的关系
 * 父类和子类线程安全的问题
 */
public class SyncDubbo2 {
    public static void main(String[] args) {
        Sub sub=new Sub();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                sub.operationSup();
            }
        });

        t1.start();
    }

    static class Main{
        public int i=10;

        public synchronized void operationMain(){
            try {
                i--;
                System.out.println("Main print i = "+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Main{
        public synchronized void operationSup(){
            try {
               while (i>0){
                   i--;
                   System.out.println("Sub print i= "+i);
                   Thread.sleep(1000);
                   this.operationMain();
               }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
