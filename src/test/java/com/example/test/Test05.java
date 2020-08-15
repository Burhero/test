package com.example.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author lhb
 * @Date 2020/8/8 9:27
 */
public class Test05 {
    @Test
    public void test1(){
        int i = 23 & 23432;
        System.out.println(i);
    }

    public static void main(String[] args) {
        /*int s = new Scanner(System.in).nextInt();
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[s];
        for (int j = 0; j <s ; j++) {
            arr[j]=scanner.nextInt();
        }*/
//  6  4  5  7  3   / 3  3  6

        //  3 3 3  4 5 6 6 7    2  8  16  20 22 31 34
        //2 3  3   4  5  6  7
       // int[] arr = new int[s];
        int[] arr = {4,6,5,7,3,3,2};
        int num=0;
        for (int i = 0; i < arr.length; i++) {
            num+=arr[i];
            //外层循环，遍历次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int aa = arr[arr.length-1];
        int bb = arr[arr.length-2];
        System.out.println("a"+aa);
        System.out.println("b"+bb);
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length-3; i >=0; i--) {
            System.out.println(i);
            System.out.println(arr[i]);
            if (aa!=bb){
                aa+=arr[i-1];
                aa+=arr[i];
            }else {
                list.clear();
                aa+=i-1;
                aa+=i;
                list.add(arr[i-2]);
            }
        }
        if (list.isEmpty()){
            System.out.println("是空");
        }
        list.forEach(System.out::println);
    }
    @Test
    public   void test02(){
        int[] arr = {1,2,5};
        System.out.println(dp(arr, 2));
    }


    private int dp(int[] arr,int n){
        if (n == 0) return	0;
        if (n < 0) return -1;
        int dp;
        int res=Integer.MAX_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            dp = dp(arr, n - arr[i]);
            if (dp==-1) continue;
            res = Math.min(res,1+dp);
        }
        if	(res !=	Integer.MAX_VALUE){
            return res;
        }	else	return -1;
    }
}
