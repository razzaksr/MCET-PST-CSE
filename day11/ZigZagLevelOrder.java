package day11;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import day10.TreeNode;

public class ZigZagLevelOrder {
    public static List<List<Integer>> zigzag(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> dq = new LinkedList<>();dq.offer(root);
        boolean leftToRight = true;int size = 0;
        while(!dq.isEmpty()){
            size = dq.size();
            Deque<Integer> level = new LinkedList<>();
            for(int index=0;index<size;index++){
                TreeNode node = dq.poll();
                if(leftToRight) level.offerLast(node.data);
                else level.offerFirst(node.data);
                if(node.left!=null) dq.offer(node.left);
                if(node.right!=null) dq.offer(node.right);
            }
            result.add(new ArrayList<>(level));
            leftToRight = !leftToRight;
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(zigzag(root));
    }
}
