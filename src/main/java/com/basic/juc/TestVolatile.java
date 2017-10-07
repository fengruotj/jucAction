package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by 79875 on 2017/10/7.
 * 一.Volatile 关键字:当多个线程操作共享数据时,保证内存中的数据可见的。
 *                   相较于synchronized 是一种较为轻量级的同步策略
 *             注意：1.volatile 不具备“互斥性”
 *                  2.volatile 不能保证变量原子性
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo threadDemo=new ThreadDemo();
        new Thread(threadDemo).start();

        //Java语言的关键字，当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。
        //或者用synchronized关键字解决 让它从主存中刷新读取数据
        while (true){
//            synchronized (threadDemo) {
                if (threadDemo.isFlag()) {
                    System.out.println("-------------------------------------------");
                    break;
                }
        //    }
        }
    }
}

class ThreadDemo implements Runnable{

    private volatile boolean flag=false;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=true;
        System.out.println("flag= "+isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
