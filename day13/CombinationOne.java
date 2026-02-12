package day13;

import java.util.ArrayList;
import java.util.List;

public class CombinationOne {
    public static List<List<Integer>> combinationSum(int[] cand, int target){
        List<List<Integer>> finList = new ArrayList<>();
        rollBack(cand, target, 0, new ArrayList<>(), finList);
        return finList;
    }
    public static void rollBack(int[] cand, int target, 
        int start, List<Integer> current, List<List<Integer>> finList){
            if(target==0){finList.add(new ArrayList<>(current)); return;}
            if(target<0) return;
            for(int index=start;index<cand.length;index++){
                current.add(cand[index]);
                rollBack(cand, target-cand[index], index, current, finList);
                current.remove(current.size()-1);
            }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5,7}, 7));
    }
}
