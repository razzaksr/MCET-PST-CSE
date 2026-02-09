package day10;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeafs {
    public static int findSum(TreeNode root){
        if(root==null) return 0;
        int sum = 0;TreeNode dummy;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            dummy = que.poll();
            if(dummy.left!=null){
                if(dummy.left.left==null&&dummy.left.right==null)
                    sum+=dummy.left.data;
                else que.offer(dummy.left);
            }
            if (dummy.right!=null) que.offer(dummy.right);
        }
        return sum;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left=new TreeNode(10);
        root.right.right=new TreeNode(8);
        System.out.println(findSum(root));
    }
}
