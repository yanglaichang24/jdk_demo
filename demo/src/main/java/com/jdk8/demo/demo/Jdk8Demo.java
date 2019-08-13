package com.jdk8.demo.demo;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.IntBinaryOperator;


/**
 * Created by yanglaichang on 2019/5/24.
 */
public class Jdk8Demo {

    private final static String salutation ="hello!";

    /**
     * lambda 表达式
     *
     * （parameters） -> expression
     *  OR
     *  (parameters) -> {statements;}
     *
     *  () -> 5;
     *
     *  x -> 2 * x
     *
     *  (x,y) -> x-y;
     *
     *  (int x,int y) -> x+y;
     *
     *  (String s) -> System.out.print(s)
     *
     */


    @Test
    public void test(){
        //类型声明
        MathOperation mathOperation = (int a, int b) -> a + b;

        //不用类型声明
        MathOperation subtraction = (a,b) -> a - b;

        //大括号的返回语句
        MathOperation mulp = (int a,int b) ->{return a * b;};

        //没有大括号的及返回语句
        MathOperation intBinaryOperator = (int a, int b) -> a / b;

        System.out.println(operate(10,5,mathOperation));
        System.out.println(operate(10,5,subtraction));

    }

    public int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }



    interface MathOperation{

        int operation(int a,int b);

    }



    //---------------------------------------------------
    // 变量作用域
    // lambda 表达式只能引用标记了final 的外层局部变量，这就是说不能在lambda 内部修改定义在域外的局部变量
    @Test
    public void test2(){
        final String salutation2 ="hello!";
        GreetingService service  = message -> System.out.print(salutation + message);
        service.sayMessage(salutation);

        GreetingService service2  = message -> System.out.print(salutation2 + message);
        service2.sayMessage(salutation2);

    }

    interface GreetingService{
        void sayMessage(String message);
    }



 // 我们也可以直接在lambda 表达式中访问外层的局部变量
    @Test
    public void test3(){
        // lambda 表达式的局部变量可以不用声明为final ,但是必须不可被后面的代码修改（隐性的具有final 的语义）
        final int num = 1;
        Converter<Integer,String> s = param -> System.out.print(String.valueOf(param + num));
        s.convert(2);
        //num =5


        // lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量
        //int i = 1;
        Comparator<Integer> comparator  =  (i,  j) -> Integer.compare(i, j);




    }

    public interface Converter<T1,T2>{
        void convert(int i);
    }














}
