package day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSofGraph {
    public static ArrayList<Integer> bfs(
        ArrayList<List<Integer>> adj){
        
        ArrayList<Integer> finList = new ArrayList<>();
        int size = adj.size();
        boolean[] visited = new boolean[size];
        Queue<Integer> level = new LinkedList<>();
        level.offer(0);visited[0] = true;
        while(!level.isEmpty()){
            int current = level.poll();finList.add(current);
            for(int neigh:adj.get(current)){
                if(!visited[neigh]){
                    visited[neigh]=true;level.offer(neigh);
                }
            }
        }
        return finList;
    }
    public static void main(String[] args) {
        ArrayList<List<Integer>> myGraph = new ArrayList<>();
        myGraph.add(List.of(2,3,1));
        myGraph.add(List.of(0));
        myGraph.add(List.of(0,4));
        myGraph.add(List.of(0));
        myGraph.add(List.of(2));
        System.out.println(bfs(myGraph));
    }
}
