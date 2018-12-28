package com.view.linkedList;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/13
 * Time : 17:38
 */
public class MergeLinked {


    public static void main(String[] args) {
        //buildLinked1 2
        int[] arr1 = {1, 2, 5, 7};
        int[] arr2 = {2, 3, 5, 8};
        Node head1 = buildLinked(arr1);
        printLinked(head1);
        Node head2 = buildLinked(arr2);
        printLinked(head2);
        //merge
        Node newHead = mergeLinked(head1, head2);
        //print
        printLinked(newHead);
    }

    private static void printLinked(Node newHead) {
        Node tmp = newHead;

        StringBuilder sb = new StringBuilder();

        while (tmp != null) {
            sb.append(tmp.getVal()).append("->");
            tmp = tmp.getNext();
        }
        System.out.println(sb.toString());
    }

    private static Node mergeLinked(Node head1, Node head2) {

        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head = null;

        if (head1.getVal() <= head2.getVal()) {
            head = head1;
            head.setNext(mergeLinked(head1.getNext(), head2));
        } else {
            head = head2;
            head.setNext(mergeLinked(head1, head2.getNext()));
        }
        return head;
    }

    private static Node buildLinked(int[] arr) {
        Node head = null;
        for (int anArr : arr) {
            if (head == null) {
                head = new Node(anArr);
                continue;
            }
            Node tmp = head;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.setNext(new Node(anArr));
        }
        return head;
    }

}
