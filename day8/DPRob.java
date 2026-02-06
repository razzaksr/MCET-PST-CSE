package day8;

public class DPRob {
    public static int robbing(int[] houses){
        if(houses == null || houses.length == 0) return 0;
        if(houses.length == 1) return houses[0];
        int prev2=0,prev1=0,current=0;
        prev2= houses[0] ;
        prev1 = Math.max(houses[0],houses[1]);
        for(int index = 2; index<houses.length;index++){
            current = Math.max(prev1, prev2 + houses[index]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    public static void main(String[] args) {
        System.out.println(robbing(new int[]{1,2,3,1}));
        System.out.println(robbing(new int[]{2,7,9,3,1}));
    }
}
