package day11;

import java.util.ArrayList;

public class RightView {
    public static ArrayList<Integer> view(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        findDepth(root, 0, result);
        return result;
    }
    public static void findDepth(Node node, int depth, ArrayList<Integer> result)
    {
        if(node==null) return;
        if(depth==result.size()) result.add(node.data);
        findDepth(node.right, depth+1, result);
        findDepth(node.left, depth+1, result);
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        System.out.println(view(root));
    }
}
