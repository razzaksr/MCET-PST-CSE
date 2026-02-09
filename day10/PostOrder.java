package day10;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public static List<Integer> readIn(TreeNode node){
        List<Integer> travelled = new ArrayList<>();
        recur(node,travelled);
        return travelled;
    }
    public static void recur(TreeNode node, List<Integer> res){
        if(node == null) return;
        recur(node.left, res);
        recur(node.right, res);
        res.add(node.data);
    }
}
