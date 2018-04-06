package com.basic.juc.future;

/**
 * locate com.basic.juc.future
 * Created by mastertj on 2018/4/6.
 */
public class RealData implements Data{

    private String result;

    public RealData(String queryStr) {
        System.out.println("这是一个查询操作，并且查询操作是一个很耗时的操作");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result="查询结果";
    }

    public String getRequest(){
        System.out.println("返回结果: "+result);
        return result;
    }
}
