package com.basic.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/6.
 */
public class UseCncurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> concurrentHashMap=new ConcurrentHashMap<>();
        for (int i = 0; i < 1000; i++) {
            concurrentHashMap.put(Integer.valueOf(i),"tanjie");
        }

        for (Integer key : concurrentHashMap.keySet()) {
            if (key == 5) {
                concurrentHashMap.remove(key);
            }else
                System.out.println(concurrentHashMap);
        }
    }
}
