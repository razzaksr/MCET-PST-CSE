package day8;

public class DPFriendsPairing {
    public static int viaDC(int limit){
        if(limit==1||limit==2) return limit;
        return viaDC(limit-1)+(limit-1)*viaDC(limit-2);
    }
    public static int viaDP(int limit){
        int[] dp = new int[limit+1];
        for(int index = 0;index<=limit;index++){
            if(index<=2) dp[index] = index;
            else dp[index] = dp[index-1]+(index-1)*dp[index-2];
        }
        return dp[limit];
    }
    public static void main(String[] args) {
        System.out.println(viaDP(4));
        System.out.println(viaDP(3));
        System.out.println(viaDP(2));
    }
}
