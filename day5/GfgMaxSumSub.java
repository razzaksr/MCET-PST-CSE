package day5;

public class GfgMaxSumSub {
    public static int findMAximum(int[] arr, int window){
        int size = arr.length, win_sum=0, fin_sum=0, index = 0;
        while(index<window){win_sum += arr[index];index++;}
        fin_sum = win_sum;
        index = window;
        while(index<size){
            win_sum += arr[index] - arr[index-window];
            fin_sum = Math.max(fin_sum, win_sum);
            index++;
        }
        return fin_sum;
    }
    public static void main(String[] args) {
        int[] arr = {100,200,300,400};
        int window = 2;
        System.out.println(findMAximum(arr, window));
    }
}
