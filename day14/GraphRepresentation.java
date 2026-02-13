package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphRepresentation {
    private int[][] adjMat;
    private List<List> adjList;
    private Map<Integer, List<Integer>> adjMap;
    private int size;
    public GraphRepresentation(int vSize){
        size = vSize;
        adjMat = new int[size][size];
        adjList = new ArrayList<>();
        for(int index = 1;index<=size;index++) adjList.add(new ArrayList<>());
        adjMap = new HashMap<>();
    }
    public void buildMatrix(int vertex1, int vertex2, int weight)
        {adjMat[vertex1][vertex2] = weight;}
    public void viewMatrix(){
        for(int[] row:adjMat)
            System.out.println(Arrays.toString(row));
    }
    public void buildList(int vertex1, int vertex2, int weight)
        {adjList.get(vertex1).add(weight);}
    public void viewList(){System.out.println(adjList);}
    public void buildMap(int vertex, int value, int weight){
        adjMap.putIfAbsent(vertex, new ArrayList<>());
        adjMap.get(vertex).add(weight);
    }
    public void viewMap(){System.out.println(adjMap);}
    public static void main(String[] args) {
        GraphRepresentation represent = new GraphRepresentation(7);
        represent.buildMap(0, 1, 10);
        represent.buildMap(0, 4, 80);
        represent.buildMap(1, 3, 20);
        represent.buildMap(0, 6, 50);
        represent.buildMap(2, 5, 30);
        represent.buildMap(3, 2, 165);
        represent.viewMap();
    }
}
