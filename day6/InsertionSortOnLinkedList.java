package day6;

import java.util.List;

public class InsertionSortOnLinkedList {
    public static  class ListNode{
        int val; ListNode next;ListNode(){}
        ListNode(int v){this.val = v;}
        ListNode(int v, ListNode n){this.val = v; this.next = n;}
    }
    public static ListNode sort(ListNode head){
        if(head==null) return null;
        ListNode dummy = new ListNode(0);dummy.next = head;
        ListNode current = head;
        while(current!=null){
            if(current.next!=null&&current.next.val<current.val){
                ListNode point = current.next;
                ListNode position = dummy;
                while(position.next.val<point.val) position = position.next;
                current.next = point.next;
                point.next = position.next;
                position.next = point;
            }
            else current = current.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode returned = sort(head);
        while(returned!=null){
            System.out.println(returned.val);
            returned = returned.next;
        }
    }
}
