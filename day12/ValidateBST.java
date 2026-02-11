package day12;

import day10.TreeNode;

public class ValidateBST {
    public static boolean isValid(TreeNode root){
        return verify(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean verify(TreeNode node, long min,long max){
        if(node==null) return true;
        if(node.data<=min||node.data>=max) return false;
        return verify(node.left,min,node.data)&&
        verify(node.right,node.data,max);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValid(root));
        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValid(root));
    }
}
