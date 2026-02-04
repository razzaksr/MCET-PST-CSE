package day5;

import java.util.Hashtable;

public class MajorityElement {
    public static int viaHt(int[] arr){
        Hashtable<Integer, Integer> tab = new Hashtable<>();
        for(int each:arr){
            tab.put(each, tab.getOrDefault(each, 0)+1);
            if(tab.get(each)>arr.length/2) return each;
        }
        return -1;
    }
    // moore voting algorithm
    public static int findMajor(int[] arr){
        int number = 0, count = 0;
        for(int each:arr){
            if(count==0) number = each;
            count += (each==number)?1:-1;
        }
        return number;
    }
    public static void main(String[] args) {
        // System.out.println(findMajor(new int[]{3,2,3}));
        // System.out.println(findMajor(new int[]{2,2,1,1,1,2,2}));
        System.out.println(viaHt(new int[]{3,2,3}));
        System.out.println(viaHt(new int[]{2,2,1,1,1,2,2}));
    }
}
