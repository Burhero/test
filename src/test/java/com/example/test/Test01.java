package com.example.test;


import org.junit.Test;

/**
 * @Description
 * @Author lhb
 * @Date 2020/7/15 14:44
 */
public class Test01 {
    @Test
    public void test1(){
        //主动引用
        System.out.println(Son.M);
        System.out.println("---------我是分割线--------");
        //被动引用不会初始化
     //   System.out.println(Son.b);
    }

}
class Father{
    static int b=2;
    static {
        System.out.println("父类静态方法被调用");
    }
}
class Son extends Father{
    static {
        System.out.println("子类静态方法被调用");
        m=300;
    }
    static  int  m =100;
    static  final int M=1;
}