package day4;

public class MostWater {
    public static int findMax(int[] arr){
        int start = 0, end = arr.length-1, maxArea = 0;
        int width =0, ht =0;
        while(start<end){
            width = end - start;
            ht = Math.min(arr[start], arr[end]);
            maxArea = Math.max(maxArea, width * ht);
            if(arr[start]<arr[end]) start++;
            else end--;
        }
        return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(findMax(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
