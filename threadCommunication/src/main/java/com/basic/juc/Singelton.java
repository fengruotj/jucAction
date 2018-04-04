package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/4.
 */
public class Singelton {
    static {
        System.out.println("Singelton static init");
    }

    public Singelton(){
        System.out.println("Singelton construction");
    }

    public static Singelton getInstances(){
        return InnerSingleton.singelton;
    }

    public static void main(String[] args) {
        System.out.println("main");

        Singelton singelton=new Singelton();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singelton.getInstances().hashCode());
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singelton.getInstances().hashCode());
            }
        });

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singelton.getInstances().hashCode());
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    private static class InnerSingleton{
        private static Singelton singelton=new Singelton();
    }
}
