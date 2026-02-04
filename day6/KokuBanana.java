package day6;

import java.util.Arrays;

public class KokuBanana {
    public static int minSpeed(int[] arr, int hours){
        int left = 1, right = Arrays.stream(arr).max().orElse(0), mid = 0;
        while(left<right){
            mid = left + (right-left)/2;
            if(canBeEat(arr, hours, mid)) right = mid;
            else left = mid+1;
        }
        return left;
    }
    public static boolean canBeEat(int[] arr, int hours, int speed){
        int cHours = 0;
        for(int each:arr)
            cHours += (each+speed - 1)/ speed;
        return cHours <= hours;
    }
    public static void main(String[] args) {
        System.out.println(minSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(minSpeed(new int[]{30,11,23,4,20}, 5));
    }
}
