package day7;

import java.util.Arrays;

public class NonOverlap {
    public static int findAndErase(int[][] slots){
        int rCount = 0;
        Arrays.sort(slots,(row1,row2)->Integer.compare(row1[1],row2[1]));
        int[] current = slots[0];
        for(int index = 1; index<slots.length; index++){
            if(slots[index][0]< current[1])
                rCount++;
            else current = slots[index];
        }
        return rCount;
    }
    public static void main(String[] args) {
        System.out.println(findAndErase(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(findAndErase(new int[][]{{1,2},{1,2},{1,2}}));
        System.out.println(findAndErase(new int[][]{{1,2},{2,3}}));
    }
}
