package com.basic.juc.future;

/**
 * locate com.basic.juc.future
 * Created by mastertj on 2018/4/6.
 */
public class Main {
    public static void main(String[] args) {
        FutureClient client=new FutureClient();
        Data data = client.request("请求参数");
        System.out.println("请求发送成功");
        System.out.println("可以做其他事情...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = data.getRequest();
        System.out.println(result);
    }
}
