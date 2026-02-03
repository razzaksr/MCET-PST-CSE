package day5;

import java.util.Hashtable;

public class FruitBasket {
    public static int grab(int[] fruits){
        Hashtable<Integer, Integer> tab = new Hashtable<>();
        int left = 0, right = 0, maxLen = 0, size = fruits.length;
        while(right<size){
            tab.put(fruits[right], 
                tab.getOrDefault(fruits[right], 0)+1);
            while(tab.size()>2){
                tab.put(fruits[left], tab.get(fruits[left])-1);
                if(tab.get(fruits[left])==0) tab.remove(fruits[left]);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(grab(new int[]{1,2,1}));
        System.out.println(grab(new int[]{0,1,2,2}));
        System.out.println(grab(new int[]{1,2,3,2,2}));
    }
}
