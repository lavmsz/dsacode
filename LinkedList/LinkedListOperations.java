package com.dsa.problems.linkedlist;

public class LinkedListOperations {
    public Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node retVal = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return retVal;
    }
    public static Node insertAtLast(Node head, int data) {
        Node node = new Node(data);
        if (head == null)
            head = node;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        return head;
    }
    public Node deleteNode(Node head, int val) {
        Node temp = head;
        if (head != null && head.data == val) {
            head = head.next;
        } else {
            while (temp.next != null && temp.next.data != val) {
                temp = temp.next;
            }
            if (temp.next != null) { //found data
                temp.next = temp.next.next;
            }
        }
        return head;
    }
    public static Node search(Node head, int val) {
        Node temp = head;
        while (temp != null && temp.data != val) {
            temp = temp.next;
        }
        return temp;
    }
    public static Node insertAtBeginning(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
    }

    public void insertAtIndex(Node head,int index, int data)
    {
        int counter=0;
        Node tempNode=head;
        Node newNode = new Node(data);
        while(tempNode!=null && counter!=index -1)
        {
            tempNode = tempNode.next;
            counter++;
        }
        if(counter==index - 1){
            if(counter == 0){
                newNode.next = tempNode;
                tempNode = newNode;
            } else{
                newNode.next = tempNode.next;
                tempNode.next = newNode;
            }
        }
        printList(newNode);
        System.out.println( " END ");
        printList(tempNode);
        System.out.println( " HEAD ");
        printList(head);

    }


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        //head.next.next.next.next = new Node(5);
        //insertAtLast(head, 11);
        //head = insertAtBeginning(head, 4);

        //printList(head);
        //int searchNum = 7;
        //Node result = search(head, searchNum);
        //System.out.println("Searching :" + searchNum + " Found : " + (result == null ? -1 : result.data));

        LinkedListOperations o = new LinkedListOperations();
        printList(head);
        o.insertAtIndex(head,3, 90);
        System.out.println();
    }
}
