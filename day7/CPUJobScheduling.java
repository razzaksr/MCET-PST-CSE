package day7;

import java.util.Hashtable;

public class CPUJobScheduling {
    public static int schedule(char[] jobs, int size){
        Hashtable<Character, Integer> table = new Hashtable<>();
        int max = 0, maxCount = 0;
        for(char each:jobs){
            table.put(each,table.getOrDefault(each, 0)+1);
            max = Math.max(max, table.get(each));
        }
        for(char key: table.keySet()){if(table.get(key) == max) maxCount++;}
        int processed = (max-1)*(size+1)+maxCount;
        return Math.max(processed, jobs.length);
    }
    public static void main(String[] args) {
        System.out.println(schedule(new char[]{'A','A','A','B','B','B'},2));
        System.out.println(schedule(new char[]{'A','A','A','B','B','B'},3));
        System.out.println(schedule(new char[]{'A','C','A','D','B','B'},1));
    }
}
