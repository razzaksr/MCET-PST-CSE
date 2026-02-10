package day11;

import day10.TreeNode;

public class GoodPairLeafs {
    public static int findPairs(TreeNode root, int dist){
        int[] res = new int[1];
        traverse(root, dist, res);
        return res[0];
    }
    public static int[] traverse(TreeNode node, int dist, int[] res){
        if(node==null) return new int[dist+1];
        if(node.left==null&&node.right==null){
            int[] temp = new int[dist+1];temp[0]=1;return temp;
        }
        int[] subLeft = traverse(node.left, dist, res);
        int[] subRight = traverse(node.right, dist, res);
        for(int index = 0; index<dist;index++){
            if(subLeft[index]==0) continue;
            for(int comp=0;comp<dist;comp++){
                if(subRight[comp]==0) continue;
                if(index+comp+2<=dist) 
                    res[0] += subLeft[index]*subRight[comp];
            }
        }
        int[] current = new int[dist+1];
        for(int index=0;index<dist;index++) 
            current[index+1]=subLeft[index]+subRight[index];
        return current;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(findPairs(root, 3));
    }
}
