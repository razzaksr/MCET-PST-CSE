package day9;

public class RobII {
    public static int roundRob(int[] houses){
        int size = houses.length;
        if(size==1) return houses[0];
        int leftSum = 0, rightSum = 0;
        leftSum = findSum(houses,0,size-2);
        rightSum = findSum(houses, 1, size-1);
        return Math.max(leftSum,rightSum);
    }
    public static int findSum(int[] arr, int begin, int end){
        int prev1=0, prev2=0, current=0;
        for(int index=begin;index<=end;index++){
            current = Math.max(prev1,prev2+arr[index]);
            prev2=prev1;prev1=current;
        }
        return prev1;
    }
    public static void main(String[] args) {
        System.out.println(roundRob(new int[]{2,3,2}));
        System.out.println(roundRob(new int[]{1,2,3,1}));
        System.out.println(roundRob(new int[]{1,2,3}));
    }
}
