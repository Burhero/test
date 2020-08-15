package com.example.test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {

    }
    public static void main(String[] args) {
        int arr[] = {25,84,21,47,15,27,68,35,20};
       // countingSort(arr);
        //radixSort(arr);
        shellSort(arr);
       // sort(arr,0,arr.length-1);
       // InsertSort(arr);
        int len = arr.length;
        for(int i:arr)
            System.out.print(i + " ");
    }
    public static void InsertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp = arr[i], j = i;
            if(arr[j-1]>temp){
                while(j>0 && arr[j-1]>temp){
                    arr[j] = arr[j-1];
                    j--;
                }
            }
            arr[j] = temp;
            for(int x:arr)
                System.out.print(x + ",");
            System.out.println();
        }
    }

    public static void sort(int[] arr, int start, int end){
        int i = start, j = end;
        if(start>=end)
            return;
        int base = arr[start]; // 以最左边的数值为基准值
        while(start<end){
            while(start<end && arr[end]>=base)
                end--;
            if(start<end)
                arr[start++] = arr[end];
            while(start<end && arr[start]<=base)
                start++;
            if(start<end)
                arr[end--] = arr[start];
            for(int x:arr)
                System.out.print(x + ",");
            System.out.println();
        }

        arr[start] = base;
        sort(arr, start+1, j);
        sort(arr, i, start-1);
    }


    public static void shellSort(int[] arr){
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
            for(int x:arr)
                System.out.print(x + ",");
            System.out.println();
        }
    }
    public static void countingSort(int[] arr){
        int min = arr[0], max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max)
                max = arr[i];
            if(arr[i]<min)
                min = arr[i];
            for(int j:arr)
                System.out.print(j + " ");
            System.out.println();
        }

        int[] bucket = new int[max-min+1];
        for(int i=0;i<arr.length;i++)
            bucket[arr[i]-min]++;

        int index = 0, i = 0;
        while(index<arr.length){
            if(bucket[i]!=0){
                arr[index] = i + min;
                bucket[i]--;
                index++;
            }
            else
                i++;
        }
    }

    public static void radixSort(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
            if(arr[i]>max)
                max = arr[i];

        int maxDigit = 0; // 最大位数
        while(max!=0){
            max /= 10;
            maxDigit++;
        }

        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for(int i=0;i<10;i++)
            bucketList.add(new ArrayList<Integer>());
        for(int j:arr)
            System.out.print(j + " ");
        System.out.println();
        for(int i=0;i<maxDigit;i++, mod*=10,div*=10){
            for(int j=0;j<arr.length;j++){
                int num = (arr[j] % mod)/div;
                bucketList.get(num).add(arr[j]);
            }
            int index = 0;
            for(int j=0;j<bucketList.size();j++){
                for(int k=0;k<bucketList.get(j).size();k++){
                    arr[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }

        }
    }
}
