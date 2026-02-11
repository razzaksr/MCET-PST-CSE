package day12;

import java.util.LinkedList;
import java.util.Queue;

import day10.PreOrder;
import day10.TreeNode;

public class SerializeDeSerialize {
    public static void preOrder(TreeNode node, StringBuffer encoded){
        if(node==null) return;
        encoded.append(node.data).append(" ");
        preOrder(node.left, encoded);
        preOrder(node.right, encoded);
    }
    public static String serialize(TreeNode root){
        StringBuffer crypt = new StringBuffer();
        preOrder(root, crypt);
        return crypt.toString().trim();
    }
    public static TreeNode verify(Queue<Integer> que, int min, int max){
        if(que.isEmpty()) return null;
        int value = que.peek();
        if(value<min||value>max) return null;
        que.poll();
        TreeNode node = new TreeNode(value);
        node.left = verify(que, min, value);
        node.right =verify(que, value, max);
        return node;
    }
    public static TreeNode deserialize(String crypt){
        if(crypt.isEmpty()) return null;
        String[] splitted = crypt.split(" ");
        Queue<Integer> que = new LinkedList<>();
        for(String each:splitted) 
            que.offer(Integer.parseInt(each));
        return verify(que, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        String encod = serialize(root);
        System.out.println(PreOrder.readPre(deserialize(encod)));
    }
}
