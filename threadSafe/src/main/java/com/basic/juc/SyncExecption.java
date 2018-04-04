package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 * synchronized有异常
 */
public class SyncExecption {
    private int i=0;

    public static void main(String[] args) {
        SyncExecption syncExecption=new SyncExecption();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                syncExecption.operation();
            }
        });

        t1.start();
    }

    public synchronized void operation(){
        while (true){
            try {
                i++;
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName()+" ,i= "+i);
                if(i==10){
                    Integer.parseInt("a");
                }
            } catch (Exception e) {
                /**
                 * 出现异常按照 正常逻辑进行处理
                 * continue
                 */
                System.out.println("long info i= "+i);
                e.printStackTrace();
                continue;
            }
        }
    }
}
