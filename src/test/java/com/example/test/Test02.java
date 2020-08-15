package com.example.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author lhb
 * @Date 2020/7/16 16:00
 */
public class Test02 {
    @Test
    public void test(){
        System.out.println(UUID.randomUUID().toString().replaceAll("-", "").substring(0,10));
    }
    @Test
    public void test1(){
        String s = "1qwe/weq/";
        String[] split = s.split("/");
        System.out.println(split.length);
        System.out.println(split[2]);
        List<String> list = new ArrayList<>();
        list.isEmpty();
        HashMap<String, Object> aa = new HashMap<>();
        aa.isEmpty();
        JSONObject jsonObject = new JSONObject();
        jsonObject.isEmpty();
    }
    public void test2(){
        //匿名内部类
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        //调用
        TreeSet<Integer> set = new TreeSet<>(comparator);
    }
    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }
    @Test
    public void test3(){
        String s = generateShortUuid();
        System.out.println(s);
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            new Thread(()-> System.out.println(finalI +generateShortUuid())).start();
        }
    }

    public static  int num = 0;
    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    @Test
    public  void test4() throws InterruptedException {
        //开启30个线程进行累加操作
        for(int i=0;i<30;i++){
            new Thread(){
                public  void run(){
                    test02();
                }


            }.start();
        }

        //等待计算线程执行完
        countDownLatch.await();
        System.out.println(num);
    }
    public synchronized void test02() {
        for(int j=0;j<10000;j++){
            num++;//自加操作
        }
        countDownLatch.countDown();
    }

    //使用原子操作类
    public static AtomicInteger num1 = new AtomicInteger(0);

    @Test
    public  void test5() throws InterruptedException {
        //开启30个线程进行累加操作
        for (int i = 0; i < 30; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        num1.incrementAndGet();//原子性的num++,通过循环CAS方式
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        //等待计算线程执行完
        countDownLatch.await();
        System.out.println(num1);
    }
}
