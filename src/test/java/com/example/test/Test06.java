package com.example.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Description
 * @Author lhb
 * @Date 2020/8/8 9:27
 */
public class Test06 {
    @Test
    public void test1(){
        HashMap<String,Integer> hashtable = new HashMap();
        hashtable.put(null,1);
        hashtable.put("2",1);

    }
    private int replace(String str){
        if (isHuiWen(str)||str.length()==0){ return 0;}
        char[] chars = str.toCharArray();
        int num=0;
        for (int i = 0; i <= chars.length/2; i++) {
            if (chars[i] == chars[chars.length-i-1]) {
                continue;
            }else {
                chars[i] = chars[chars.length-i-1];
            }
            String s = chars.toString();
            num++;
            if (isHuiWen(s)){
                return num;
            }
        }
        return num;
    }
    public static boolean isHuiWen(String text) {
        int length = text.length();
         for (int i = 0; i < length / 2; i++) {
             if (text.toCharArray()[i] != text.toCharArray()[length - i - 1]) {
               return false;
            }
         }
         return true;
    }
}
