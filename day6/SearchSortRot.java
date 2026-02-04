package day6;

public class SearchSortRot {
    public static int find(int[] arr, int seek){
        int left = 0, right = arr.length-1, mid=0;
        while(left<=right){
            mid = left + (right - left) / 2;
            if(arr[mid]==seek) return mid;
            if(arr[left]<=arr[mid]){
                if(seek>=arr[left]&&seek < arr[mid]) right = mid-1;
                else left = mid+1;
            }
            else{
                if(seek>arr[mid]&&seek<=arr[right]) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(find(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(find(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
