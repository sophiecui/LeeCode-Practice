package com.company;

//import java.util.Stack;

import java.util.Comparator;
import java.util.PriorityQueue;
public class Main {

    public static void main(String[] args) {
        int[] array = {2,2,2,1};

        System.out.println(thirdMax(array));
    }
    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if(a < b){
                    return 1;
                }
                return -1;
            }
        });

        for(int i = 0; i < nums.length; i++ ){
            q.add(nums[i]);
        }


        int i = 1;
        int max = q.peek();
        int result = q.peek();
        while(!q.isEmpty() && i < 3){
            if(result != q.peek()){

                result = q.peek();
                i++;
            }
            q.poll();

        }
        System.out.println("i = "+i);
        if(i < 3){
            System.out.println("return max = " + max);
            return max;
        }
        System.out.println("return result = " + result);
        return result;


    }
}
