package day6;

public class SearchInMatrix {
    public static boolean binary(int[][] arr, int seek){
        int rSize = arr.length;
        int cSize = arr[0].length;
        int left = 0, right = rSize*cSize-1, mid = 0;
        int row=0, col=0;
        while(left<=right){
            mid = left+(right-left)/2;
            row = mid/cSize;col = mid%cSize;
            if(arr[row][col]==seek) return true;
            else if(arr[row][col]<seek) left = mid+1;
            else right= mid-1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(binary(arr, 3));
        System.out.println(binary(arr, 13));
    }
}
