package day10;

public class CountNodes {
    public static int total(TreeNode root){
        if(root==null) return 0;
        return 1+total(root.left)+total(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(8);
        System.out.println(total(root));
    }
}
