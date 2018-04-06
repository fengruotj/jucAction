package com.basic.juc;

import java.util.ArrayList;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/6.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        // 复现方法一
//        Iterator<Integer> iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            if (integer.intValue() == 5) {
//                arrayList.remove(integer);
//            }
//        }

        // 复现方法二
//        for (Integer value : arrayList) {
//            if (value == 5) {
//                arrayList.remove(value);
//            }
//        }

        final ArrayList<Integer> finalArrayList=arrayList;
        arrayList.remove(0);
        System.out.println(finalArrayList);
    }
}
