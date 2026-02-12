package day13;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    static String[] pad = 
        {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterComb(String digits){
        List<String> finList = new ArrayList<>();
        rollBack(digits, 0, new StringBuffer(), finList);
        return finList;
    }
    public static void rollBack(String digits, int index, 
        StringBuffer current,List<String> finList){
        if(index==digits.length()){finList.add(current.toString());return;}
        String comb = pad[digits.charAt(index)-'0'];
        for(char each:comb.toCharArray()){
            current.append(each);
            rollBack(digits, index+1, current, finList);
            current.deleteCharAt(current.length()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(letterComb("72925"));
    }
}
