package day6;

public class MinInRotSort {
    public static int find(int[] arr){
        int left = 0, right = arr.length-1, mid = 0;
        while(left<right){
            mid = left+(right-left)/2;
            if(arr[mid]>arr[right])
                left = mid+1;
            else right= mid;
        }
        return arr[left];
    }
    public static void main(String[] args) {
        System.out.println(find(new int[]{3,4,5,1,2}));
        System.out.println(find(new int[]{4,5,6,7,0,1,2}));
        System.out.println(find(new int[]{11,13,15,17}));
    }
}
