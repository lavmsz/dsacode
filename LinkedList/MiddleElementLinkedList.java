package com.dsa.problems.linkedlist;

public class MiddleElementLinkedList {
    public static int findMiddleElement(Node head) {
        Node current = head;
        Node leap = head;
        while(leap!=null && leap.next!=null){
            current = current.next;
            leap = current.next.next;
        }
        return current.data;
    }

    public static int findMidElemRecurse(Node head, Node leap) {
        if(leap==null || leap.next==null)
            return head.data;
        return findMidElemRecurse(head.next,leap.next.next);
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
        //head.next.next.next.next.next = new Node(6);

        printList(head);
        //int result = findMiddleElement(head);
        int result = findMidElemRecurse(head,head);
        System.out.println("result new: " + result);

    }
}
