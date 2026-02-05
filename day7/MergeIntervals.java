package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] allocate(int[][] slots){
        if(slots.length == 0) return new int[0][];
        Arrays.sort(slots,(row1,row2)->Integer.compare(row1[0],row2[0]));
        List<int[]> finList = new ArrayList<>();
        int[] current = slots[0];
        for(int index = 1; index<slots.length; index++){
            if(slots[index][0] <= current[1])
                current[1]=Math.max(current[1],slots[index][1]);
            else{finList.add(current);current = slots[index];}
        }
        finList.add(current);
        return finList.toArray(new int[finList.size()][]);
    }
    public static void main(String[] args) {
        int[][] slots = {{1,3},{2,4},{5,7},{6,8}};
        int[][] result = allocate(slots);
        for(int[] arr: result){System.out.print(Arrays.toString(arr)+", ");}
        System.out.println();
        int[][] slots2 = {{1,4},{2,3}};
        int[][] result2 = allocate(slots2);
        for(int[] arr: result2){System.out.print(Arrays.toString(arr)+", ");}
        System.out.println();
        int[][] slots3 = {{4,7},{1,4}};
        int[][] result3 = allocate(slots3);
        for(int[] arr: result3){System.out.print(Arrays.toString(arr)+", ");}
        System.out.println();
        int[][] slots4 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result4 = allocate(slots4);
        for(int[] arr: result4){System.out.print(Arrays.toString(arr)+", ");}
        System.out.println();
    }
}
