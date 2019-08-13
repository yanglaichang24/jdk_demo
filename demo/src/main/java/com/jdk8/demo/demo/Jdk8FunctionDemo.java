package com.jdk8.demo.demo;

import org.junit.Test;

/**
 * Created by yanglaichang on 2019/5/28.
 */
public class Jdk8FunctionDemo {

    /**
     *  函数式接口（Functional interface）就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口
     *  函数式接口可以被隐式转换为lambda 表达式
     *  lambda 表达式和方法引用
     *  定义一个函数式接口如下
     */
    @Test
    public void test(){

        //用lambda表达式来表示来表示该接口的一个实现
        Demo demo = message -> System.out.println("" + message) ;
        demo.demo("ee");
    }


    @FunctionalInterface
    public interface Demo{
        void demo(String mes);
    }





}
