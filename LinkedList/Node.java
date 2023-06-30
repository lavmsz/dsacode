package com.dsa.problems.linkedlist;

public class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
    }

    public String toString() {
        return this.data+"";
    }
}
