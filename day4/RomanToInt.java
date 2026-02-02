package day4;

import java.util.Hashtable;

public class RomanToInt {
    public static int toInt(String roman){
        Hashtable<Character, Integer> tab = new Hashtable<>();
        tab.put('I', 1);tab.put('V', 5);
        tab.put('X', 10);tab.put('L', 50);
        tab.put('C', 100);tab.put('D', 500);
        tab.put('M', 1000);
        int total = 0, value= 0 ;
        for(int index = 0; index<roman.length();index++){
            value = tab.get(roman.charAt(index));
            if(index+1<roman.length()&&value<tab.get(roman.charAt(index+1)))
                total -= value;
            else
                total += value;
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(toInt("MCMXCIV"));
    }
}
