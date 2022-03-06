package com.abc.dingzheng.java.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        list.sort((o1, o2) -> o1-o2==0?0:o1-o2>0?1:-1);
        System.out.println(list);
        list.sort((o1, o2) -> o2-o1==0?0:o2-o1>0?1:-1);
        System.out.println(list);

    }
}
