package day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> finList = new ArrayList<>();
        List<Integer> byLevel = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList();
        int size = 0;TreeNode polled = null;
        que.offer(root);
        while(!que.isEmpty()){
            size = que.size();byLevel = new ArrayList();
            for(int index = 0; index<size;index++){
                polled = que.poll();byLevel.add(polled.data);
                if(polled.left!=null) que.offer(polled.left);
                if(polled.right!=null) que.offer(polled.right);
            }
            finList.add(byLevel);
        }
        return finList;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(8);
        System.out.println(levelOrder(root));
    }
}
