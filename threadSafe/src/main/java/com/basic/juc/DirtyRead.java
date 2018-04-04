package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * 脏读：对于对象的同步和异步方法，我们在设计自己的程序的时候，一定要考虑问题的整体，不然就出会现数据不一致的错位，很经典的错误就是脏读
 * DirtyRead
 */
public class DirtyRead {
    private String username="tanjie";
    private String password="123";

    public static void main(String[] args) {
        final DirtyRead dirtyRead=new DirtyRead();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                dirtyRead.setValue("tanjie","456");
            }
        },"t1");

        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dirtyRead.getVaule();
    }

    public synchronized void setValue(String username,String password){
        this.username=username;

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password=password;

        System.out.println("setValue最终结果：username= "+this.username+" password= "+this.password);
    }

    /**
     * synchronized
     */
    public synchronized void getVaule(){
        System.out.println("getVaule方法得到：username= "+this.username+" password= "+this.password);
    }
}
