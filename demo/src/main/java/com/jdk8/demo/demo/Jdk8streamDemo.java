package com.jdk8.demo.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by yanglaichang on 2019/7/1.
 */
public class Jdk8streamDemo {


    /**
     * java8 api 添加了一个新的抽象称为流Stream 可以让你以一种声明的方式处理数据
     *
     * Stream 使用一种类似用sql语句从数据库查询数据的直观方式类提供一种对Java集合运算和表达的高阶抽象
     *
     * Stream api 可以极大提高Java程序员的的生产力，让程序员写出高效，赶紧，简洁的代码
     *
     * 这种风格将要处理的元素集合看作一种流，留在管道中传输，并且可以在管道的节点上进行处理，比如筛选，
     * 排序，聚合，
     *
     *元素流在管道中经过中间操作的处理，最后由最终操作得到前面的处理的结果
     *
     *
     *
     *Stream 是一个来自数据源的元素队列并支持聚合操作
     *
     *
     * 元素是特定类型的对象，形成一个队列，Java中的stream并不会存储元素，而是按需计算
     *
     * 数据源 流的来源，可以是集合，数组，I/O channel 产生器generator等
     *
     * 聚合操作 类似SQL语句一样的操作，比如filter，map,reduce,find,match,sorted 等
     *
     * 和以前的collection 操作不同，stream 操作还有两个基础的特征：
     *
     *
     * pipeling 中间操作都会返回流对象本身，这样多个操作可以串联成一个管道，如同流式风格
     * 这样做对操作进行优化，比如延迟执行和短路
     *
     *
     * 内部迭代：以前对集合遍历都是通过iterator 或者 for-each的方式，显示的在集合外部进行迭代
     *
     * 的方式，通过反问者模式实现
     *
     *
     * 生成流
     *
     * 在Java8 中集合接口与两个方法来生成流
     *
     * stream（） 为集合创建串你串行流
     *
     * parallelStream()  为集合创建并行流
     *
     *
     *
     */
    @Test
    public void test(){
        // 生成流
        List<String> strings = Arrays.asList("a", "b", "c","");
        List<String> collect = strings.stream().filter(String -> !String.isEmpty()).collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.toArray()));

        //forEach
        //stream 提供了新的方法foreache 来迭代流中的每个数据，以下代码片段使用foreach
        // 输出10哥随机数

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::print);

        //map
        //map 方法用于映射每个元素到对应的结果
        List<String> collect1 = strings.stream().map(i -> i + i)
                .distinct().collect(Collectors.toList());


        System.out.println(Arrays.toString(collect1.toArray()));


        //filter
        //filter 方法用于通过设置的条件过滤出元素。
        List<String> collect3 = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());

        System.out.println("filter:"+Arrays.toString(collect3.toArray()));


    }










}
