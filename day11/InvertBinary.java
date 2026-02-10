package day11;

import day10.LevelOrder;
import day10.TreeNode;

public class InvertBinary {
    public static TreeNode mirror(TreeNode root){
        if(root==null) return null;
        TreeNode each = root.left;
        root.left = root.right;
        root.right = each;
        mirror(root.left);
        mirror(root.right);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root = mirror(root);
        System.out.println(LevelOrder.levelOrder(root));;
    }
}
