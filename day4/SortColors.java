package day4;

import java.util.Arrays;

public class SortColors {
    public static void dutchman(int[] arr){
        int start = 0, end = arr.length-1, index = 0;
        while(index<=end){
            if(arr[index]==0){
                arr[start] ^= arr[index];
                arr[index] ^= arr[start];
                arr[start] ^= arr[index];
                start++;index++;
            }
            else if(arr[index]==1) index++;
            else{
                int third = arr[index];
                arr[index] = arr[end];
                arr[end] = third;
                end--;
            }
        }
    }
    public static void main(String[] args) {
        // int[] case1 = new int[]{2,0,2,1,1,0};
        int[] case1 = new int[]{2,2};
        dutchman(case1);
        System.out.println(Arrays.toString(case1));
    }
}
