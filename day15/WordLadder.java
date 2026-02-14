package day15;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static int ladderLength(String begin, String end, 
        List<String> wordList){
        
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(end)) return 0;
        Queue<String> que = new LinkedList<>();que.offer(begin);
        Set<String> visited = new HashSet<>();visited.add(begin);
        int level = 1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int index=0;index<size;index++){
                String polled = que.poll();
                if(polled.equals(end)) return level;
                char[] chars = polled.toCharArray();
                for(int pos=0;pos<chars.length;pos++){
                    char og = chars[pos];
                    for(char c= 'a';c<='z';c++){
                        if(c==og) continue;
                        chars[pos]=c; String newOne = new String(chars);
                        if(dict.contains(newOne)&&!visited.contains(newOne)){
                            visited.add(newOne);que.offer(newOne);
                        }
                    }
                    chars[pos]=og;// retrore
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog",
         List.of("hot","dot","dog","lot","log","cog")));
    }
}
