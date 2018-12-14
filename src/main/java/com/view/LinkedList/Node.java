package com.view.LinkedList;

import java.util.PriorityQueue;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/13
 * Time : 17:37
 */
public class Node {

    private Node next;

    private int val;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }
}
