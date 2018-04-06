package com.basic.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/5.
 */
public class Main {
    public static void main(String[] args) {
//        List<Integer> integers=new ArrayList<>();
//        integers.add(1);
//        integers.add(3);
//        integers.add(2);
//        for(Integer integer1:integers){
//            System.out.println(integer1);
//        }
//
//        Integer integer = integers.get(0);
//        integer=8888;
//
//        for(Integer integer2:integers){
//            System.out.println(integer2);
//        }
//
//        List<String> stringList=new ArrayList<>();
//        stringList.add("1");
//        stringList.add("2");
//        stringList.add("3");
//        for(String str1:stringList){
//            System.out.println(str1);
//        }
//
//        String str = stringList.get(0);
//        str="tanjie";
//
//        for(String str2:stringList){
//            System.out.println(str2);
//        }

        List<StringBuilder> stringList=new ArrayList<>();
        stringList.add(new StringBuilder("1"));
        stringList.add(new StringBuilder("1"));
        stringList.add(new StringBuilder("1"));

        for(StringBuilder str1:stringList){
            System.out.println(str1);
        }

        StringBuilder str = stringList.get(0);
        str.append("222");

        for(StringBuilder str2:stringList){
            System.out.println(str2);
        }

//        List<User> userList=new ArrayList<>();
//        userList.add(new User("tanjie","123456"));
//        userList.add(new User("tanjie","1234567"));
//        userList.add(new User("tanjie","12345678"));
//        for(User user1:userList){
//            System.out.println(user1);
//        }
//
//        User user = userList.get(0);
//        user.setPassowrd("798750509");
//
//        for(User user2:userList){
//            System.out.println(user2);
//        }
    }
}
