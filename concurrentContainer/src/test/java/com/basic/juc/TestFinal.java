package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/6.
 */
public class TestFinal {
    public static void main(String[] args)  {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        String f = d + 2;
        System.out.println(c);
        System.out.println((a == c));
        System.out.println((a == e));
        System.out.println((a == f));
    }
}
