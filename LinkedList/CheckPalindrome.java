package com.dsa.problems.linkedlist;

public class CheckPalindrome {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        //head.next.next = new Node(3);
        //head.next.next.next = new Node(2);
        //head.next.next.next.next = new Node(1);
        //head.next.next.next.next.next = new Node(1);

        printList(head);
        Boolean result = isPalindrome(head);
        System.out.println("isPalindrome " + result);
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " --> ");
            head = head.next;
        }
    }
    public static boolean isPalindrome(Node head) {
        // middle of ll
        Node temp = head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //  reverse slow
        slow = reverseList(slow.next);
        //printList(slow);

        //compare left & right ll
        while(slow != null){
            if(temp.data != slow.data) return false;
            slow = slow.next;
            temp = temp.next;
        }
        return true;
    }

    public static Node reverseList(Node right) {
        if (right.next == null)
            return right;
        Node reversed = reverseList(right.next);
        right.next.next = right;
        right.next = null;
        return reversed;
    }

}
