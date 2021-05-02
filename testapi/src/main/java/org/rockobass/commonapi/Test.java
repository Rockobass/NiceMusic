package org.rockobass.commonapi;

import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
//        System.out.println(list.poll());
//        System.out.println(list.pollFirst());

        System.out.println(list.pollLast());
        System.out.println(list);
    }
}
