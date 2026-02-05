package day7;

import java.util.Arrays;

public class Pizza3Slice {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int choose = n / 3;
        // Case 1: exclude last slice
        int case1 = maxSum(Arrays.copyOfRange(slices, 0, n - 1), choose);
        // Case 2: exclude first slice
        int case2 = maxSum(Arrays.copyOfRange(slices, 1, n), choose);
        return Math.max(case1, case2);
    }
    private int maxSum(int[] arr, int choose) {
        int capacity = arr.length;
        int[] prev2 = new int[choose + 1]; 
        int[] prev1 = new int[choose + 1]; 
        int[] current  = new int[choose + 1]; 
        for (int i = 1; i <= capacity; i++) {
            for (int j = 1; j <= choose; j++) 
                current[j] = Math.max(prev1[j], prev2[j - 1] + arr[i - 1]);
            // reset
            prev2 = prev1.clone();prev1 = current.clone();
        }
        return prev1[choose];
    }
    public static void main(String[] args) {
        Pizza3Slice solution = new Pizza3Slice();
        System.out.println(solution.maxSizeSlices(new int[]{1,2,3,4,5,6}));
        System.out.println(solution.maxSizeSlices(new int[]{8,9,8,6,1,1}));
        System.out.println(solution.maxSizeSlices(new int[]{3,1,2}));
    }
}
