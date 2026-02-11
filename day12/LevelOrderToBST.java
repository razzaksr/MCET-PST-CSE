package day12;

import day10.PostOrder;
import day10.TreeNode;

public class LevelOrderToBST {
    public static TreeNode construct(Integer[] arr){
        TreeNode root = null;
        for(Integer each:arr){
            if(each!=null) root = build(root, each);
        }
        return root;
    }
    public static TreeNode build(TreeNode root, int value){
        if(root == null) return new TreeNode(value);
        if(value<root.data)
            root.left = build(root.left, value);
        else
            root.right = build(root.right,value);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = construct(
            new Integer[]{1,2,3,null,null,4,5}
        );
        System.out.println(PostOrder.readIn(root));
    }
}
