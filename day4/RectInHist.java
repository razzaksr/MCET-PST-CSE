package day4;

import java.util.Stack;

public class RectInHist {
    public static int findLargest(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int size = arr.length, maxArea = 0, cur_ht = 0, p_ht=0;
        for(int index = 0;index<=size;index++){
            cur_ht = (index==size)?0:arr[index];
            // pop and find reactangle area
            while(!stk.isEmpty()&&cur_ht<arr[stk.peek()]){
                p_ht = arr[stk.pop()];
                int width = stk.isEmpty()?index:index-stk.peek()-1;
                int area = p_ht*width;
                maxArea = Math.max(maxArea,area);
            }
            stk.push(index);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(findLargest(new int[]{2,1,5,6,2,3}));
    }
}