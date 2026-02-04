package day6;

public class BinarySearch {
    public static int lookAround(int[] arr, int seek){
        int left = 0, right = arr.length-1, mid = 0;
        while(left<=right){
            mid = left+(right-left)/2;
            if(arr[mid]==seek) return mid;
            else if(arr[mid]<seek) left = mid+1;
            else right= mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(lookAround(new int[]{1,2,3,4,5,6,7,8,9}, 5));
        System.out.println(lookAround(new int[]{10,20,30,40,50}, 25));
        System.out.println(lookAround(new int[]{-1,0,3,5,9,12}, 9));
    }
}
