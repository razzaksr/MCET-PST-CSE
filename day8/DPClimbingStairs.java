package day8;

public class DPClimbingStairs {
    public static int climb(int stairs){
        if(stairs <= 2) return stairs;
        int[] dp = new int[stairs+1];
        dp[1] = 1; dp[2] = 2;
        for(int index=3; index<=stairs;index++)
            dp[index] = dp[index-1] + dp[index-2];
        return dp[stairs];
    }
    public static int climbViaDC(int stairs){
        if(stairs <= 0) return 0;
        if(stairs <= 2) return stairs;
        else return climb(stairs-1) + climb(stairs-2);
    }
    public static void main(String[] args) {
        System.out.println(climb(2));
        System.out.println(climb(3));
        System.out.println(climb(4));
        System.out.println(climb(5));
    }
}
