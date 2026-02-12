package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetTwo {
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> finList = new ArrayList<>();
        Arrays.sort(nums);
        rollBack(nums, 0, new ArrayList<>(), finList);
        return finList;
    }
    public static void rollBack(int[] nums,int start, List<Integer> current,
        List<List<Integer>> finList){
        finList.add(new ArrayList<>(current));
        for(int index=start;index<nums.length;index++){
            if(index>start&&nums[index]==nums[index-1]) continue;
            current.add(nums[index]);
            rollBack(nums, index+1, current, finList);
            current.remove(current.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,2}));
    }
}
