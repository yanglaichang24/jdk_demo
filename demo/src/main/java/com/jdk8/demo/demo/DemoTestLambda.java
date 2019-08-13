package com.jdk8.demo.demo;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

/**
 * Created by yanglaichang on 2019/5/17.
 */
public class DemoTestLambda {

    @Test
    public void test(){

        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");


        /**Collections.sort(names1, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/


        Collections.sort(names1, (o1, o2) -> o1.compareTo(o2));

        System.out.println("test22" + Arrays.toString(names1.toArray()));


        Consumer<String> stringConsumer = (String s) -> System.out.println("4444");
        //stringConsumer.


        IntBinaryOperator binaryOperator = (int a, int b) -> a + b;
        int i = binaryOperator.applyAsInt(1, 2);
        System.out.println("add:"+ i);





    }

}
