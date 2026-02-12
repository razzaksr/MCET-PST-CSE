package day13;

import java.util.ArrayList;
import java.util.List;

public class CombinationThree {
    public static List<List<Integer>> combinationSum3(int buffer, int target){
        List<List<Integer>> finList = new ArrayList<>();
        rollBAck(1, buffer, target, new ArrayList<>(), finList);
        return finList;
    }
    public static void rollBAck(int start, int buffer, int target, 
        List<Integer> current, List<List<Integer>> finList){
        if(current.size()==buffer&&target==0){
            finList.add(new ArrayList<>(current));return;}
        if(current.size()>buffer||target<0) return;
        for(int index=start;index<=9;index++){
            current.add(index);
            rollBAck(index+1, buffer, target-index, current, finList);
            current.remove(current.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }
}
