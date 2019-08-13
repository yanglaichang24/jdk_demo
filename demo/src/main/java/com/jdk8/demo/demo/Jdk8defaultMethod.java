package com.jdk8.demo.demo;

import org.junit.Test;

/**
 *
 * <p>
 *     java 8 新增了接口的默认方法
 *     简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法
 *     我们只需在方法前面加个default 关键字即可实现默认方法
 *
 *     NOTE 首先，之前的接口是个双刃剑，好处是面向抽象而不是面向具体的流程，缺陷是，当需要修改接口时候
 *     需要修改全部实现该接口的类，目前的java8 之前的结合框架没有foreach 方法，通常能想到的解决办法是在
 *     jdk 里给相关的接口添加新的方法及实现。然而，对于已经发布的版本，
 *     是没法在给接口添加新方法的同时不影响已有的实现，所以引进的默认方法，他们的目的是为了解决接口的
 *     的修改与现有的实现不兼容的问题
 *
 * </p>
 *
 *
 *
 *
 *
 *
 * Created by yanglaichang on 2019/6/27.
 */
public class Jdk8defaultMethod {


    //语法
    public interface Vehicle{
        default void print(){
            System.out.println("I am car !!");
        }
    }


    // 多个默认方法
    // 一个接口有默认方法，考虑这样的情况，一个类实现了多个接口，而且这些接口有相同的默认办法，
    public interface FourWheeler{
        default void print(){
            System.out.println("I am fourwheeler");

        }
    }

    //1.第一个解决方案是创建自己的默认方法，来覆盖接口的默认方法
    public class Car implements Vehicle,FourWheeler{


        @Override
        public void print() {
            System.out.println("default ");
        }
    }

    //2. 第二个解决可以使用super来调用指定接口的默认方法
    public class Car2 implements Vehicle,FourWheeler{

        @Override
        public void print() {
            Vehicle.super.print();
        }
    }



    //静态默认方法
    //java8 的另一个特性是接口可以声明（并且可以提供实现）静态方法
    public interface Vehicle2{

        default void print(){
            System.out.println("我是一辆车");
        }

        static void blowHorn(){
            System.out.println("按喇叭！！！");
        }

    }















    @Test
    public void test(){

    }





}
