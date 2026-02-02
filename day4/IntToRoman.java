package day4;

public class IntToRoman {
    public static String toRoman(int number){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String roman = "";
        for(int index = 0; index<values.length;index++){
            while(number>=values[index]){
                number -= values[index];
                roman += symbols[index];
            }
        }
        return roman;
    }
    public static void main(String[] args) {
        System.out.println(toRoman(1994));
        System.out.println(toRoman(3749));
    }
}
