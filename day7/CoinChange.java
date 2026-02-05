package day7;

import java.util.Arrays;

public class CoinChange {
    public static int find(int[] arr, int target){
        int init = target+1;
        int[] dp = new int[init];
        Arrays.fill(dp, init);
        dp[0] = 0;
        for(int currency:arr){
            for(int index = currency;index<init;index++)
                dp[index] = Math.min(dp[index], 1+dp[index-currency]);
        }
        return (dp[target]<init)?dp[target]:-1;
    }
    public static void main(String[] args) {
        System.out.println(find(new int[]{1,2,5},11));
        System.out.println(find(new int[]{100,500},200));
        System.out.println(find(new int[]{100,500},600));
        System.out.println(find(new int[]{100,500},450));
    }
}
