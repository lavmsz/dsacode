package com.dsa.problems.linkedlist;

public class FoldList143 {

    public static void main(String args[]) {
        com.dsa.problems.linkedlist.Node head = new com.dsa.problems.linkedlist.Node(1);
        head.next = new com.dsa.problems.linkedlist.Node(2);
        head.next.next = new com.dsa.problems.linkedlist.Node(3);
        head.next.next.next = new com.dsa.problems.linkedlist.Node(4);
        head.next.next.next.next = new com.dsa.problems.linkedlist.Node(5);
        //head.next.next.next.next.next = new Node(6);
        printList(head.next.next);
        FoldList143 o = new FoldList143();

        System.out.println("");
        o.reorderList(head);
        printList(head);
    }

    public static void printList(com.dsa.problems.linkedlist.Node head) {
        com.dsa.problems.linkedlist.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
    }


    public void reorderList(com.dsa.problems.linkedlist.Node head) {
        com.dsa.problems.linkedlist.Node prev=head;
        com.dsa.problems.linkedlist.Node curr=head;
        com.dsa.problems.linkedlist.Node tail=head;
        if(head.next!=null)
            tail=recursive(curr,prev);
        tail.next=null;
    }
    public static com.dsa.problems.linkedlist.Node recursive(com.dsa.problems.linkedlist.Node curr, com.dsa.problems.linkedlist.Node prev){
        if(curr.next==null){
            com.dsa.problems.linkedlist.Node temp=prev.next;
            prev.next=curr;
            curr.next=temp;
            return temp;
        }

        com.dsa.problems.linkedlist.Node temp=recursive(curr.next,prev);
        if(temp==curr){
            temp.next=null;
            return temp;
        }
        if(temp.next==null)
            return temp;
        if(temp.next==curr){
            temp.next.next = null;
            return temp.next;
        }
        com.dsa.problems.linkedlist.Node swap=temp.next;
        temp.next=curr;
        curr.next=swap;
        return swap;
    }
}
