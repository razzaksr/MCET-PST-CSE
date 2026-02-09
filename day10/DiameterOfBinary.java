package day10;

public class DiameterOfBinary {
    static int diameter;
    public static int findDiameter(TreeNode root){
        diameter = 0;
        findDepth(root);
        return diameter;
    }
    public static int findDepth(TreeNode node){
        if(node==null) return 0;
        int leftDepth = findDepth(node.left);
        int rightDepth = findDepth(node.right);
        diameter = Math.max(diameter,leftDepth+rightDepth);
        return 1+Math.max(leftDepth, rightDepth);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right=new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(8);
        System.out.println(findDiameter(root));
    }
}
