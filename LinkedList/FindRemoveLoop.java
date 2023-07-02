package com.dsa.problems.linkedlist;

import java.util.*;

public class FindRemoveLoop {



    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        printList(head.next.next);
        head.next.next.next.next.next.next.next.next = head.next.next;

        System.out.println("");
        findLoopDel(head);
        printList(head);
    }

    public static void findLoopDel(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                System.out.println("Loop Detected");
                removeLoop(fast,head);
            }
        }
    }

    private static void removeLoop(Node loopNode, Node head) {
        int k = 1;
        Node ptr1 = loopNode;
        Node ptr2 = loopNode;
        System.out.println("ln " + loopNode.data);
        while(ptr1.next != ptr2){
            ptr1 = ptr1.next;
            k++;
        }
        System.out.println("k " + k);

        ptr1 = head;
        ptr2 = head;
        //keep ptr1 at head and ptr2 at head + k
        for(int i=0; i<k; i++){
            ptr2 = ptr2.next;
        }
        System.out.println("****************");

        //advance ptr1,ptr2 by 1 step until their next is equal
        //or find loop starting node
        Node prev = ptr2;
        while(ptr1 != ptr2){
            ptr1  = ptr1.next;
            prev = ptr2;
            ptr2  = ptr2.next;
        }
        //when the star node is found point ptr2 to null
        if(ptr1 == ptr2){
            prev.next = null;
        }

    }

    public static void findLoopDelHash(Node head){
        Set <Node> set = new HashSet< >();
        Node prev = head;
        Node curr = head;
        while(curr != null){
            if(set.contains(curr)){
                System.out.println("Loop Detected");
                prev.next = null;
                return;
            }
            set.add(curr);
            prev = curr;
            curr = curr.next;
        }
        printList(head);
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
    }

}
