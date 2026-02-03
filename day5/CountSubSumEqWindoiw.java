package day5;

import java.util.Hashtable;

public class CountSubSumEqWindoiw {
    public static int findCount(int[] arr, int window){
        Hashtable<Integer, Integer> tab = new Hashtable<>();
        tab.put(0, 1);
        int count = 0, sum = 0;
        for(int each:arr){
            sum+=each;
            if(tab.containsKey(sum-window)) count += tab.get(sum-window);
            tab.put(sum, tab.getOrDefault(sum, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(findCount(new int[]{1,1,1},2));
        System.out.println(findCount(new int[]{1,2,3},3));
    }
}
