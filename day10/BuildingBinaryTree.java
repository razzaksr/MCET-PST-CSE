package day10;

class TreeNodes<T>{
    T data;
    TreeNodes<T> left,right;
    public TreeNodes(){}
    public TreeNodes(T  value){
        this.data = value;
        this.left = new TreeNodes<>();
        this.right = new TreeNodes<>();
    }
    public TreeNodes<T> buildTree(T arr[]){
        if(arr.length==0) {
            System.out.println("Can't build tree");
            return null;
        }
        return construct(arr, 0);
    }
    public TreeNodes<T> construct(T[] arr, int index){
        if(index>=arr.length || arr[index]==null) return null;
        TreeNodes<T> node = new TreeNodes(arr[index]);
        node.left = construct(arr, 2*index+1);
        node.right = construct(arr, 2*index+2);
        return node;
    }
    public void readIn(TreeNodes<T> root){
        if(root==null) return;
        readIn(root.left);
        System.out.print(root.data+" ");
        readIn(root.right);
    }
}


public class BuildingBinaryTree {
    public static void main(String[] args) {
        TreeNodes<String> strTree = new TreeNodes();
        strTree = strTree.buildTree(new String[]{"DBMS","DAA","DSA","OS","Network","PCD"});
        strTree.readIn(strTree);
        System.out.println();
        TreeNodes<Integer> intTree = new TreeNodes();
        intTree = intTree.buildTree(new Integer[]{3,9,7,5,1,10,8});
        intTree.readIn(intTree);
        System.out.println();
        TreeNodes objTree = new TreeNodes();
        objTree = objTree.buildTree(new Object[]{"Razak",90,3.4,true,'R'});
        objTree.readIn(objTree);
    }
}
