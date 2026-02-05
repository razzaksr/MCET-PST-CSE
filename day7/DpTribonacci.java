package day7;

public class DpTribonacci {
    public static int viaConstant(int limit){
        if(limit==0) return 0;
        if(limit==1||limit==2) return 1;
        int prev3 = 0, prev2 = 1, prev1 = 1, sum=0;
        for(int index = 3;index<=limit;index++){
            sum = prev1+prev2+prev3;prev3 = prev2;prev2 = prev1;prev1 = sum;
        }
        return prev1;
    }
    public static int viaMemory(int limit){
        if(limit==0) return 0;
        if(limit==1||limit==2) return 1;
        int[] dp = new int[limit+1];dp[0] = 0;dp[1] = 1;dp[2] = 1;
        for(int index = 3;index<=limit;index++)
            dp[index] = dp[index-1]+dp[index-2]+dp[index-3];
        return dp[limit];
    }
    public static void main(String[] args) {
        System.out.println(viaConstant(4));
        System.out.println(viaConstant(25));
        System.out.println(viaConstant(35));
    }
}
