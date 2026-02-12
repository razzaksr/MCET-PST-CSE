package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationTwo {
    public static List<List<Integer>> permutationUnique(int[] nums){
        List<List<Integer>> finList = new ArrayList<>();
        int size = nums.length;
        Arrays.sort(nums);
        rollBAck(nums, new boolean[size], new ArrayList<>(), finList);
        return finList;
    }
    public static void rollBAck(int[] nums, boolean[] visted, 
        List<Integer> current, List<List<Integer>> finList){
        if(current.size()==nums.length)
            {finList.add(new ArrayList<>(current)); return;}
        for(int index= 0 ; index<nums.length;index++){
            if(visted[index]) continue;
            if(index>0&&nums[index]==nums[index-1]&&!visted[index-1])continue;
            visted[index]=true; current.add(nums[index]);
            rollBAck(nums, visted, current, finList);
            current.remove(current.size()-1);visted[index]=false;
        }
    }
    public static void main(String[] args) {
        System.out.println(permutationUnique(new int[]{1,2,3}));
    }
}
