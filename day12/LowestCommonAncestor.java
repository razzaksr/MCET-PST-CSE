package day12;

import day10.TreeNode;

public class LowestCommonAncestor {
    public static TreeNode findAncestor(
        TreeNode root, TreeNode child1, TreeNode child2){
            while(root!=null){
                if(child1.data<root.data&&child2.data<root.data)
                    root = root.left;
                else if(child1.data>root.data&&child2.data>root.data)
                    root = root.right;
                else return root;
            }
            return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode parent = findAncestor(
            root, new TreeNode(1), new TreeNode(3));
        System.out.println(parent.data);
    }
}

/*
R
10
   20
     30

        
     20
10          30

LR
    30
10
    20
Left rotation done at leaf
        30
    20
10
right rotation done at root
    20
10      30

*/