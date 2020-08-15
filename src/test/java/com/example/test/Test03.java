package com.example.test;

import org.junit.Test;

import java.util.*;


/**
 * @Description
 * @Author lhb
 * @Date 2020/7/22 16:24
 */
public class Test03 {
    @Test
    public void test01(){
       /* String pass = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(pass);
        System.out.println(encode);
        boolean matches = bCryptPasswordEncoder.matches("123456", "$2a$10$LQxASCdOZueRKJhZBBZbqOo7TY3ihp2C6ujTbryhHz88o7t156TmS");
        System.out.println(matches);
        boolean b = bCryptPasswordEncoder.upgradeEncoding(encode);
        System.out.println(b);*/

    }
    @Test
    public void test02() {

        Map<String,Integer> map = new HashMap<>();
        String str = "abc";
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        map.put("d", 2);
        //遍历map集合 将值为1的key替换为“ ”
        for(Map.Entry<String, Integer> entry:map.entrySet()){

            if( entry.getValue()==1){
                String str2 = entry.getKey();
                System.out.println(str2);
                str = str.replace(str2, " ");

            }

        }
        System.out.println(str);
    }
    @Test
    public void test3(){
        int arr[] = {25,84,21,47,15,27,68,35,20};
        System.out.println("初始序列的数组为:");
        for(int r=0;r<arr.length;r++){
            System.out.print(arr[r]+",");
        }
        for(int h = arr.length/2;h>0;h=h/2){
            for(int i=h;i<arr.length;i++){
                int temp = arr[i], j = 0;
                for(j=i-h;j>=0;j=j-h){
                    if (temp<arr[j])
                        arr[j+h] = arr[j];
                    else
                        break;
                }
                arr[j+h] = temp;
            }
            System.out.println("\n排好序的数组为:");
            for(int r=0;r<arr.length;r++){
                System.out.print(arr[r]+",");
            }
        }
        System.out.println("\n排好序的数组为:");
        for(int r=0;r<arr.length;r++){
            System.out.print(arr[r]+",");
        }

    }
    @Test
    public void test4(){
        int a=1;
        System.out.println(aa(a));

    }
    private int aa(int a){
        int num =0;
        if (a>0){
            int i = a / 3;
            int i1 = a % 3;
            num+=i;
            if (i>0){
                int i2 = i + i1;
                int aa=0;
                if (i2!=2){
                    aa = aa(i2);
                }else {
                    aa=1;
                }
                num+=aa;
            }else {
                return num;
            }
        }
        return num;
    }
}
