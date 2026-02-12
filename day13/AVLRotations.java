package day13;

import day10.LevelOrder;
import day10.TreeNode;

public class AVLRotations {
    public static int getHeight(TreeNode node){
        if(node==null) return 0;
        return Math.max(
            getHeight(node.left), getHeight(node.right))+1;
    }
    public static int getFactor(TreeNode node){
        if(node==null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }
    public static TreeNode rightRotation(TreeNode node){
        TreeNode child = node.left;
        TreeNode leaf = child.right;
        child.right = node;
        node.left = leaf;
        return child;
    }
    public static TreeNode leftRotation(TreeNode node){
        TreeNode child = node.right;
        TreeNode leaf = child.left;
        child.left = node;
        node.right = leaf;
        return child;
    }
    public static TreeNode insert(TreeNode root, int newOne){
        if(root==null) return new TreeNode(newOne);
        if(newOne < root.data) root.left = insert(root.left, newOne);
        else if(newOne>root.data) root.right = insert(root.right, newOne);
        else return root;
        int currentFactor = getFactor(root);
        // Left skewed tree >> right rotation
        if(currentFactor>1&&newOne<root.left.data)
            return rightRotation(root);
        // Rightskewed tree>> left rotation
        if(currentFactor<-1 && newOne>root.right.data)
            return leftRotation(root);
        // Left right
        if(currentFactor>1&&newOne>root.left.data){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        // right left rotation
        if(currentFactor<-1&&newOne<root.right.data){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = null;
        int[] nums = {25,20,15};
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.levelOrder(root));
        nums = new int[]{25,30,40};root=null;
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.levelOrder(root));
        nums = new int[]{25,20,22};root=null;
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.levelOrder(root));
        nums = new int[]{25,30,28};root=null;
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.levelOrder(root));
        nums = new int[]{100,150,50,200,125,110};root=null;
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.levelOrder(root));
    }
}
