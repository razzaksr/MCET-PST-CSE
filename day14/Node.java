package day14;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int data;
    List<Node> neighbors;
    public Node(int value)
    {data= value;neighbors = new ArrayList<>();}
    public Node(int _val, ArrayList<Node> _neighbors) 
        {data = _val;neighbors = _neighbors;}
    public Node() 
        {data = 0;neighbors = new ArrayList<Node>();}
    public String toString(){return "Node: "+data+" "+neighbors+"\n";}
}
