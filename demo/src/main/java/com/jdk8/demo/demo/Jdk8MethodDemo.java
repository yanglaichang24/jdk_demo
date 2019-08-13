package com.jdk8.demo.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * // java 8 方法引用
 * <p>
 *     方法引用通过方法的名字来指向一个方法
 *     方法引用实用一对冒号::
 *
 * </p>
 *
 *
 *
 * Created by yanglaichang on 2019/5/27.
 */
public class Jdk8MethodDemo {

    /**
     * 4中不同的方法作为自理来区分java 中4中不用方法的引用
     */
    @Test
    public void test(){

        //Jdk8MethodDemo Jdk8MethodDemo = Jdk8MethodDemo::new;


        //构造器引用语法 Class::new  || Class<T>::new
        Jdk8MethodDemo jdk8MethodDemo = Jdk8MethodDemo.create(Jdk8MethodDemo::new);

        List<Jdk8MethodDemo> list = Arrays.asList(jdk8MethodDemo);

        //静态方法引用 语法 Class::static_method
        list.forEach(Jdk8MethodDemo::collide);

        //特定类的任意对象的方法的使用 语法class::method
        list.forEach(Jdk8MethodDemo:: repair);

        //特定对象的方法引用
        Jdk8MethodDemo jdk8MethodDemo2 = Jdk8MethodDemo.create(Jdk8MethodDemo::new);
        list.forEach(jdk8MethodDemo2::follow);

    }



    @FunctionalInterface
    public interface Supplier<T>{
        T get();
    }

    public static Jdk8MethodDemo create(Supplier<Jdk8MethodDemo> supplier){
        return supplier.get();
    }

    public static void collide(final Jdk8MethodDemo demo){
        System.out.println("collided"+demo.toString());
    }

    public void follow(final Jdk8MethodDemo demo){
        System.out.println("Flo" + demo.toString());
    }

    public void repair(){
        System.out.println("repaired" + this.toString());
    }






}
