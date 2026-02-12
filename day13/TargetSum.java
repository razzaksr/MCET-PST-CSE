package day13;

import java.util.Arrays;

public class TargetSum {
    public static int findTargetSum(int[] nums, int target){
        int sum = 0;
        sum = Arrays.stream(nums).sum();
        if(Math.abs(target)>sum) return 0;
        if((target+sum)%2!=0) return 0;
        int subsetSum = (target+sum)/2;
        return countSubsetsFreq(nums, subsetSum);
    }
    public static int countSubsetsFreq(int[] nums, int target){
        int[] dp = new int[target+1];dp[0]=1;
        for(int each:nums)
            for(int index=target;index>=each;index--)
                dp[index] += dp[index-each];
        return dp[target];
    }
    public static void main(String[] args) {
        System.out.println(findTargetSum(new int[]{1,1,1,1,1}, 3));
    }
}
