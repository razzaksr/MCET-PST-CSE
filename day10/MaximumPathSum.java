package day10;

public class MaximumPathSum {
    static int maxSum;
    public static int maxPathSum(TreeNode root){
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }
    public static int maxGain(TreeNode node){
        if(node==null) return 0;
        int leftGain = Math.max(maxGain(node.left),0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int newPrice = node.data+leftGain+rightGain;
        maxSum = Math.max(maxSum,newPrice);
        return node.data+Math.max(leftGain,rightGain);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
}
