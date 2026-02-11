package day12;

import day10.InOrder;
import day10.TreeNode;

public class DeleteAtBST {
    public static TreeNode findMin(TreeNode node){
        while(node.left!=null) node = node.left;
        return node;
    }
    public static TreeNode deleteNode(TreeNode root, int key){
        if(root==null) return null;
        if(key<root.data) root.left = deleteNode(root.left, key);
        else if(key>root.data) root.right = deleteNode(root.right, key);
        else{
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode next = findMin(root.right);
            root.data = next.data;
            root.right = deleteNode(root.right, next.data);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root = deleteNode(root, 3);
        System.out.println(InOrder.readIn(root));;
    }
}
