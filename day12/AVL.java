package day12;

import java.util.ArrayList;
import java.util.List;

import day10.TreeNode;

public class AVL {
    public static void doIn(TreeNode node, List<Integer> nums){
        if(node == null) return;
        doIn(node.left, nums);
        nums.add(node.data);
        doIn(node.right, nums);
    }
    public static TreeNode doBalance
    (List<Integer> nums, int left, int right){
        if(left>right) return null;
        int mid = left+(right-left)/2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = doBalance(nums, left, mid-1);
        node.right = doBalance(nums, mid+1, right);
        return node;
    }
    public static TreeNode balanceBST(TreeNode root){
        List<Integer> inList = new ArrayList<>();
        doIn(root, inList);
        return doBalance(inList, 0, inList.size()-1);
    }
}
