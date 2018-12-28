package com.view.linkedList;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/12
 * Time : 17:28
 */
public class BianLiLink {

    static class Node {
        private int val;
        private Node next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        Node root = buildLink();
        Node node = root;
        while (node != null && node.getNext() != null) {
            System.out.println(node.getVal());
            node = node.getNext();
        }

    }

    private static Node buildLink() {
        Node head = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        head.setVal(1);
        head.setNext(node1);
        node1.setVal(2);
        node1.setNext(node2);
        node2.setVal(3);
        node2.setNext(node3);
        node3.setVal(4);
        node3.setNext(node4);
        node4.setVal(5);
        node4.setNext(node5);
        node5.setVal(6);
        node5.setNext(null);
        return head;
    }

}
