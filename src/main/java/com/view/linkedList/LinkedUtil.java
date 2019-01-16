package com.view.linkedList;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2019/1/7
 * Time : 17:24
 * Project : View
 */
public class LinkedUtil {

    public static Node buildLinked(int[] arr) {
        Node head = null;
        for (int anArr : arr) {
            if (head == null) {
                head = new Node(anArr);
                continue;
            }
            Node tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new Node(anArr));
        }
        return head;
    }


    public static void printLinked(Node node) {
        Node tmp = node;
        StringBuilder sb = new StringBuilder();
        while (tmp != null) {
            if (tmp.getNext() != null) {
                sb.append(tmp.getVal()).append("->");
            }
            tmp = tmp.getNext();
        }
        System.out.println(sb.toString());
    }


}
