package day11;

import java.util.ArrayList;
import java.util.Collections;

public class BoundaryTraversal {
    public static boolean isLeaf(Node node){
        return (node.left==null&&node.right==null);
    }
    public static void leftBoundary(Node node, ArrayList<Integer> finList){
        Node current = node.left;
        while(current!=null){
            if(!isLeaf(current)) finList.add(current.data);
            if(current.left!=null) current = current.left;
            else current=current.right;
        }
    }
    public static void leaves(Node node, ArrayList<Integer> finList){
        if(isLeaf(node)){
            finList.add(node.data);return;
        }
        if(node.left!=null) leaves(node.left,finList);
        if(node.right!=null) leaves(node.right,finList);
    }
    public static void rightBoundary(Node node, ArrayList<Integer> finList){
        Node current = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(current!=null){
            if(!isLeaf(current)) temp.add(current.data);
            if(current.right!=null) current=current.right;
            else current = current.left;
        }
        Collections.reverse(temp);finList.addAll(temp);
    }
    public static ArrayList<Integer> traversal(Node root){
        ArrayList<Integer> finList = new ArrayList<>();
        if(!isLeaf(root)) finList.add(root.data);
        leftBoundary(root, finList);
        leaves(root, finList);
        rightBoundary(root, finList);
        return finList;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        System.out.println(traversal(root));
    }
}
