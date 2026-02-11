package day12;

import day10.PreOrder;
import day10.TreeNode;

public class SortedArrayToBST {
    public static TreeNode constructBST(int[] arr){
        return build(arr, 0, arr.length-1);
    }
    public static TreeNode build(int[] arr, int start, int end){
        if(start>end) return null;
        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = build(arr, start, mid-1);
        node.right = build(arr, mid+1, end);
        return node;
    }
    public static void main(String[] args) {
        TreeNode root = constructBST(new int[]{-10,-3,0,5,9});
        System.out.println(PreOrder.readPre(root));
    }
}
