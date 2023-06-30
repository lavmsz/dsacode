package com.dsa.problems.linkedlist;

public class ReverseLinkedList2Pointers {
    public static Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        Node temp ;
        while(current!=null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
    public static Node recursiveReverse(Node head){
        if (head.next == null) {
            return head;
        }
        Node retVal = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return retVal;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " --> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);
        Node result = recursiveReverse(head);
        System.out.println("XOXOXO");
        printList(result);
    }
}
