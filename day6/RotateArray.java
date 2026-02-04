package day6;

import java.util.Arrays;

public class RotateArray {
    public static void roll(int[] arr, int rotate){
        int size = arr.length;
        rotate = rotate % size;
        reverse(arr, 0, size-1);
        reverse(arr, 0, rotate-1);
        reverse(arr, rotate, size-1);
    }
    public static void reverse(int[] arr, int left, int right){
        while(left<right){
            arr[left]^=arr[right];
            arr[right]^=arr[left];
            arr[left]^=arr[right];
            left++;right--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        roll(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
