package day14;

import java.util.ArrayList;
import java.util.List;

public class DFSOfGraph {
    public static ArrayList<Integer> dfs(ArrayList<List<Integer>> adj){
        int size = adj.size();
        ArrayList<Integer> finList = new ArrayList<>();
        boolean[] visited = new boolean[size];
        depth(0, adj, visited, finList);
        return finList;
    }
    public static void depth(int curr, ArrayList<List<Integer>> adj, 
        boolean[] visited, ArrayList<Integer> finList){
        
        visited[curr] = true; finList.add(curr);
        for(int neigh:adj.get(curr))
            if(!visited[neigh]) depth(neigh, adj, visited, finList);
    }
    public static void main(String[] args) {
        ArrayList<List<Integer>> myGraph = new ArrayList<>();
        myGraph.add(List.of(2,3,1));
        myGraph.add(List.of(0));
        myGraph.add(List.of(0,4));
        myGraph.add(List.of(0));
        myGraph.add(List.of(2));
        System.out.println(dfs(myGraph));
    }
}
