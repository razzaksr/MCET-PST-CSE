package day5;

import java.util.Hashtable;

public class MinWindow {
    public static String findWindow(String cur, String freq){
        if(cur.length()==0||freq.length()==0||cur.length()<freq.length())
            return "";
        Hashtable<Character, Integer> fTab = new Hashtable<>();
        int count = 0, minLen = Integer.MAX_VALUE, minStart = 0, left = 0;
        for(int index = 0; index<freq.length(); index++){
            char key = freq.charAt(index);
            fTab.put(key, fTab.getOrDefault(key, 0)+1);
        }
        Hashtable<Character, Integer> cTab = new Hashtable<>();
        for(int right=0;right<cur.length();right++){
            char key = cur.charAt(right);
            cTab.put(key, cTab.getOrDefault(key, 0)+1);
            if(fTab.containsKey(key)&&cTab.get(key).intValue()==fTab.get(key).intValue()) 
                count++;
            while(count==fTab.size()){
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    minStart = left;
                }
                char leftKey = cur.charAt(left);
                cTab.put(leftKey, cTab.get(leftKey)-1);
                if(fTab.containsKey(leftKey) && cTab.get(leftKey)<fTab.get(leftKey))
                    count--;
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : 
        cur.substring(minStart, minStart+minLen);
    }
    public static void main(String[] args) {
        String cur = "ADOBECODEBANC", freq = "ABC";
        System.out.println(findWindow(cur, freq));
    }
}
