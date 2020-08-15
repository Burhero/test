package com.example.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author lhb
 * @Date 2020/8/8 9:27
 */
public class Test07 {
    @Test
    public void test1(){
        int[][] array = new int[3][2];
        System.out.println(getNum(array));
    }
    private int getNum(int[][] array){
        List<Integer> list = new ArrayList();
        int num=0;list.add(num);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]=num;
                boolean valid ;
                for (int k = 0; k <list.size() ; k++) {
                    valid= isValid(array, list.get(k), i, j);
                    if (!valid){
                        break ;
                    }else {
                        list.add(num);
                    }
                }
                num++;
            }
        }
        return list.size();
    }
    boolean isValid(int[][] array, int num, int	row, int col)	{
        if (row>0&&col>0){
            if ((array[row-1][col] ==num)||(array[row][col-1] ==num)||(array[row-1][col-1] ==num)){
                return true;}}
        return false;
    }
}
