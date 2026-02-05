package day7;

public class GreedyJumpII {
    public static int findJump(int[] arr){
        int jumps = 0, cEnd = 0, far = 0, size = arr.length-1;
        for(int index = 0; index<size; index++){
            far = Math.max(far, index+arr[index]);
            if(index == cEnd){
                jumps++;
                cEnd = far;
                // if(cEnd <= index) return -1;
                if(cEnd>=size) return jumps;
            }
        }
        return far >= size?jumps:-1;
    }
    public static void main(String[] args) {
        System.out.println(findJump(new int[]{2,3,1,1,4}));
        System.out.println(findJump(new int[]{2,3,0,1,4}));
        System.out.println(findJump(new int[]{3,2,1,0,4}));
    }
}
