package day14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    private static Map<Node,Node> visited = new HashMap<>();
    public static Node cloneGraph(Node node){
        if(node==null) return null;
        if(visited.containsKey(node)) return visited.get(node);
        Node mirror = new Node(node.data);
        visited.put(node, mirror);
        for(Node nei:node.neighbors)
            mirror.neighbors.add(cloneGraph(nei));
        return mirror;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(1);
        node1.neighbors.addAll(List.of(node2,node4));
        node2.neighbors.addAll(List.of(node1,node3));
        node3.neighbors.addAll(List.of(node2,node4));
        node4.neighbors.addAll(List.of(node1,node3));
        Node copied = cloneGraph(node1);
        for(Node each:copied.neighbors)
            System.out.println(each);
    }
}
