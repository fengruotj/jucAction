package com.basic.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/6.
 * 自定义分区的ConcurrentHashMap
 */
public class PartitionConcurrentHashMap<K,V> {
    private ConcurrentHashMap<Integer,ConcurrentHashMap<K,V>> concurrentHashMap=new ConcurrentHashMap<>();

    private Integer maxPartitonsNum;

    public PartitionConcurrentHashMap(Integer maxPartitonsNum) {
        this.maxPartitonsNum=maxPartitonsNum;

        for(int i=0;i<maxPartitonsNum;i++){
            ConcurrentHashMap<K,V> concurrentHashMap=new ConcurrentHashMap<>();
            this.concurrentHashMap.put(i,concurrentHashMap);
        }
    }

    public void put(Integer partition, K key, V value){
        concurrentHashMap.get(partition).put(key,value);
    }

    public V get(Integer partition,K key){
        return concurrentHashMap.get(partition).get(key);
    }

    public V remove(Integer partition,K key){
        return concurrentHashMap.get(partition).remove(key);
    }
}
