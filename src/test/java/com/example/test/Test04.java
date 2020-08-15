package com.example.test;

import org.junit.Test;

/**
 * @Description
 * @Author lhb
 * @Date 2020/8/7 18:59
 */
public class Test04 {
    @Test
    public void test1(){
       // System.out.println(reverseStr("(u(love)i)"));
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        node2.next=node3;
        node.next=node2;
        Node node1 = new Node(1);
        node2=new Node(3);
        node3=new Node(4);
        node2.next=node3;
        node1.next=node2;
        Node next = mergerTwoList(node, node1).next;
        while (next != null){
            System.out.println(next.val);
            next = next.next;
        }
    }

    static class Node {
        int val;
        Node next;
        Node(int x) { val = x; }
    }
    public static Node mergerTwoList(Node list1, Node list2){
        Node head = new Node(0);
        Node result = head;
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }else{
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            }
        }
        if(list1 == null){
            head.next = list2;
        }else{
            head.next = list1;
        }
        return result.next;
    }

    public String reverseStr(String s) {
        if(s.length()<=1) return s;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                int j=i,bal=0;
                for(;j<s.length();j++) {
                    if(s.charAt(j)=='(') bal++;
                    if(s.charAt(j)==')') bal--;
                    if(bal==0) break;
                }
                StringBuilder str1=new StringBuilder(reverseStr(s.substring(i+1, j)));
                for(int k=str1.length()-1;k>=0;k--)
                    str.append(str1.charAt(k));
                i=j;
            }
            else
                str.append(s.charAt(i));
        }

        return str.toString();
    }
}
