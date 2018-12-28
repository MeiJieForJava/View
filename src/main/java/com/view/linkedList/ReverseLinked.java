package com.view.linkedList;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/13
 * Time : 18:23
 */
public class ReverseLinked {


    public static void main(String[] args) {
        //1构建链表
        int[] arr = {1, 2, 3, 4, 5, 7, 5, 43, 76};
        Node head = buildLinked(arr);
        //2.链表反转
        Node newHead = recursiveReverseLinked(head);
//        Node newHead = loopReverseLinked(head);
        //3.打印链表
        printLinked(newHead);
    }

    private static Node loopReverseLinked(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.getNext();
        while (cur.getNext() != null) {
            Node tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        cur.setNext(pre);
        head.setNext(null);
        return cur;
    }
    private static Node recursiveReverseLinked(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node temp = head.getNext();
        Node revHead = recursiveReverseLinked(head.getNext());
        temp.setNext(head);
        head.setNext(null);
        return revHead;
    }
    private static void printLinked(Node node) {
        Node tmp = node;
        StringBuilder sb = new StringBuilder();
        while (tmp != null) {
            sb.append(tmp.getVal()).append("->");
            tmp = tmp.getNext();
        }
        System.out.println(sb.toString());
    }



    private static Node buildLinked(int[] arr) {
        Node head = null;
        for (int arrAn : arr) {
            if (head == null) {
                head = new Node(arrAn);
            }
            Node tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new Node(arrAn));
        }
        return head;
    }


}
