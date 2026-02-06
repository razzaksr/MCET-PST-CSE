package day8;

public class DPDecode {
    public static int findWays(String msg){
        if(msg ==null || msg.length()==0) return 0;
        int size = msg.length(), single = 0, pair = 0;
        int[] dp = new int[size+1];
        dp[0] = 1;dp[1] = msg.charAt(0) !='0'?1:0;
        for(int index=2; index<=size;index++){
            single = msg.charAt(index-1)-'0';
            if(single >=1 &&single<=9) dp[index] +=dp[index-1];
            pair = Integer.parseInt(msg.substring(index-2,index));
            if(pair >= 10&&pair<=26) dp[index] +=dp[index-2];
        }
        return dp[size];
    }
    public static void main(String[] args) {
        System.out.println(findWays("12"));
        System.out.println(findWays("226"));
        System.out.println(findWays("06"));
        System.out.println(findWays("11106"));
    }
}
