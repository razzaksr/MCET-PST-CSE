package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public static List<Integer> readPre(TreeNode node){
        List<Integer> travelled = new ArrayList<>();
        recur(node,travelled);
        return travelled;
    }
    public static void recur(TreeNode root, List<Integer> res){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.data); // visit root
            // push right first so left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right=new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(8);
        System.out.println(readPre(root));
    }
}
