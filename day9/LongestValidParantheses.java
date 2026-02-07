package day9;

public class LongestValidParantheses {
    public static int findMax(String exp){
        char[] brackets = exp.toCharArray();
        int left = 0, right = 0, maxLen = 0;
        for(char each:brackets){
            if(each=='(') left++;
            else right++;
            if(left==right) maxLen = Math.max(maxLen,2*right);
            else if(right>left) left = right = 0;
        }
        left=right=0;
        for(int index = brackets.length-1;index>=0;index--){
            if(brackets[index]=='(') left++;
            else right++;
            if(left==right) maxLen = Math.max(maxLen,2*left);
            else if(left>right) left=right=0;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(findMax("(()"));
        System.out.println(findMax(")()())"));
    }
}
